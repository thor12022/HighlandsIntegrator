package thor12022.highlandsintegrator;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{

   public static Configuration config;
   
   // Sections to add to the config
   public static final String generalSection = "General";
   public static final String thaumcraftSection = "Thaumcraft";
   public static final String buildCraftSection = "BuildCraft";

   // Options in the config
   public static boolean doDebug = false;
   public static boolean thaumcraftHighlandsIntegration = true;
   public static boolean buildCraftHighlandsIntegration = true;
   
   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      doDebug = config.getBoolean("Debug Information",generalSection, doDebug, "");
      
      thaumcraftHighlandsIntegration = config.getBoolean("Enable Integration",thaumcraftSection, thaumcraftHighlandsIntegration, "Registers Thaumcraft biomes with Highlands");
      
      buildCraftHighlandsIntegration = config.getBoolean("Enable Integration",buildCraftSection, buildCraftHighlandsIntegration, "Registers BuildCraft biomes with Highlands");
      
      config.save();
   }
}
