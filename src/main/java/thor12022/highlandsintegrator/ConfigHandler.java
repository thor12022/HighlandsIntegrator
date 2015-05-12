package thor12022.highlandsintegrator;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.List;

public class ConfigHandler
{
   public static class ManualEntry
   {
      public int id;
      public int weight;
      public String type;
      public String modName;
   }

   public static Configuration config;

   // Sections to add to the config
   public static final String generalSection = "General";
   public static final String thaumcraftSection = "Thaumcraft";
   public static final String buildCraftSection = "BuildCraft";
   public static final String manualBiomeSection = "ManualBiomes";

   // Options in the config
   public static boolean doDebug = false;
   public static boolean thaumcraftHighlandsIntegration = true;
   public static boolean buildCraftHighlandsIntegration = true;
   public static List<ManualEntry> manualEntries;

   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      doDebug = config.getBoolean("Debug Information", generalSection, doDebug, "");

      thaumcraftHighlandsIntegration = config.getBoolean("Enable Integration", thaumcraftSection, thaumcraftHighlandsIntegration, "Registers Thaumcraft biomes with Highlands");

      buildCraftHighlandsIntegration = config.getBoolean("Enable Integration", buildCraftSection, buildCraftHighlandsIntegration, "Registers BuildCraft biomes with Highlands");

      int biomeCount = config.get(manualBiomeSection, "biomeCount", 0, "Number Manually Defined Biomes", 0, 255)
            .getInt();
      for (int count = 0; count < biomeCount; ++count)
      {
         ManualEntry entry = new ManualEntry();
         entry.id = config.get(manualBiomeSection + ".biome" + count, "id", -1, "Biome ID", 0, 255).getInt();
         entry.weight = config.get(manualBiomeSection + ".biome" + count, "weight", -1, "Biome Weight", 0, 65535).getInt();
         entry.type = config.get(manualBiomeSection + ".biome" + count, "type", "", "Type of biome [hot,warm,cool,cold,nether,ocean,sub]").getString();
         entry.modName = config.get(manualBiomeSection + ".biome" + count, "modName", "", "Name of Biome's mod e.g. 'Thaumcraft'").getString();
         manualEntries.add(entry);
      }

      config.save();
   }
}
