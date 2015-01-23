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
   public static String biomesOPlentySection = "Biomes O' Plenty";
   public static String thaumcraftSection = "Thaumcraft";

   // Options in the config
   public static boolean doDebug = false;
   public static boolean miningWorldHasCeiling = false;
   public static int miningWorldDimensionId = 6;
   public static boolean customBopHighlandsIntegration = true;
   public static boolean experimentalBopHighlandsIntegration = false;
   public static boolean thaumcraftHighlandsIntegration = true;
   public static boolean thaumcraftBiomeDictionary = true;
   
   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      doDebug = config.getBoolean("Debug Information",generalSection, doDebug, "");
      miningWorldHasCeiling = config.getBoolean("Has Ceiling", miningWorldSection, miningWorldHasCeiling, "Experimental, can cause sevre lag");
      miningWorldDimensionId = config.get(miningWorldSection, "Dimension ID", miningWorldDimensionId, "").getInt(miningWorldDimensionId);
      customBopHighlandsIntegration = config.getBoolean("Highlands Integration",biomesOPlentySection, customBopHighlandsIntegration, "Register only specific biomes");
      experimentalBopHighlandsIntegration = config.getBoolean("Experimental Highlands Integration",biomesOPlentySection, experimentalBopHighlandsIntegration, "Experimental, can cause corrupt chunks");
      thaumcraftBiomeDictionary = config.getBoolean("Biome Dictionary",thaumcraftSection, thaumcraftBiomeDictionary, "Registers biomes to Biome Dictionary");
      
      config.save();
   }
}
