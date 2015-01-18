package main.feedthecreepertweaks;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{

   public static Configuration config;
   
   // Sections to add to the config
   public static String generalSection = "General";
   public static String miningWorldSection = "Mining Dimension";

   // Options in the config
   public static boolean doDebug = false;
   public static boolean miningWorldHasCeiling = true;
   
   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      doDebug = config.getBoolean("Debug Information",generalSection, doDebug, "");
      miningWorldHasCeiling = config.getBoolean("Has Ceiling", miningWorldSection, miningWorldHasCeiling, "");
      
      config.save();
   }
}
