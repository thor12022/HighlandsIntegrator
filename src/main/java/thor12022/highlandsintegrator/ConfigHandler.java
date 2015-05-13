package thor12022.highlandsintegrator;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import thor12022.highlandsintegrator.util.TextHelper;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler
{
   public static class ManualEntry
   {
      public int id = -1;
      public int weight;
      public String type;
      public int parentId = -1;
      public String modName;
   }

   private static Configuration config;
   private static String manualJson = "[]";

   // Sections to add to the config
   public static final String generalSection = "General";
   public static final String thaumcraftSection = "Thaumcraft";
   public static final String buildCraftSection = "BuildCraft";
   public static final String manualBiomeSection = "ManualBiomes";

   // Options in the config
   public static boolean doDebug = false;
   public static boolean thaumcraftHighlandsIntegration = true;
   public static boolean buildCraftHighlandsIntegration = true;
   public static int buildCraftOceanOilFieldsWeight = 2;
   public static int buildCraftDesertOilFieldsWeight = 2;
   public static List<ManualEntry> manualEntries = new ArrayList();

   public static void init(FMLPreInitializationEvent event)
   {
      config = new Configuration(new File(event.getModConfigurationDirectory() + File.separator + ModInformation.CHANNEL + File.separator + "main.cfg"));
      String jsonFileName = event.getModConfigurationDirectory() + File.separator + ModInformation.CHANNEL + File.separator + "BiomeIntegration.json";
      try
      {
         manualJson = FileUtils.readFileToString(new File(jsonFileName), "UTF-8");
      }
      catch(IOException e)
      {
         try
         {
            PrintWriter writer = new PrintWriter(jsonFileName, "UTF-8");
            writer.print(manualJson);
            writer.close();
         }
         catch(IOException e2)
         {
            HighlandsIntegrator.logger.warn(TextHelper.localize("warning." + ModInformation.ID + ".console.load.init.biomeJson") + ": " + jsonFileName);
         }
      }
      syncConfig();
   }

   public static void syncConfig()
   {
      doDebug = config.getBoolean("Debug Information", generalSection, doDebug, "");

      thaumcraftHighlandsIntegration = config.getBoolean("Enable Integration", thaumcraftSection, thaumcraftHighlandsIntegration, "Registers Thaumcraft biomes with Highlands");

      buildCraftHighlandsIntegration = config.getBoolean("Enable Integration", buildCraftSection, buildCraftHighlandsIntegration, "Registers BuildCraft biomes with Highlands");
      buildCraftOceanOilFieldsWeight = config.get("Ocean Oil Fields Weight", buildCraftSection, buildCraftOceanOilFieldsWeight, "").getInt();
      buildCraftDesertOilFieldsWeight = config.get("Desert Oil Fields Weight", buildCraftSection, buildCraftDesertOilFieldsWeight, "").getInt();

      config.save();
      
      parseJson();
   }
   
   private static void parseJson()
   {
      JsonParser parser = new JsonParser();
      try
      {
         JsonArray biomeArray = (JsonArray)parser.parse(manualJson);
         for( int index = 0; index < biomeArray.size(); ++index)
         {
            ManualEntry entry = new ManualEntry();
            JsonObject biomeObj = biomeArray.get(index).getAsJsonObject();
            HighlandsIntegrator.logger.debug(biomeObj.toString());
            entry.id = biomeObj.get("id").getAsInt();
            entry.weight = biomeObj.get("weight").getAsInt(); 
            entry.type = biomeObj.get("type").getAsString(); 
            if(entry.type.compareTo("sub") == 0)
            {
               entry.parentId = biomeObj.get("parentId").getAsInt(); 
            } 
            entry.modName = biomeObj.get("modName").getAsString();
            manualEntries.add(entry);
         }
      }
      catch (JsonParseException e)
      {
         manualEntries.clear();
         HighlandsIntegrator.logger.warn(TextHelper.localize("warning." + ModInformation.ID + ".console.parseJson") + ": " + e.getLocalizedMessage());
      }
   }
}
