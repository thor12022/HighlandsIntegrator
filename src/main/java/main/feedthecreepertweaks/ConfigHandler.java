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
   public static final String generalSection = "General";
   public static final String miningWorldSection = "Mining Dimension";
   public static final String biomesOPlentySection = "Biomes O' Plenty";
   public static final String thaumcraftSection = "Thaumcraft";
   public static final String progressiveAutomationSection = "Progressive Automation";
   public static final String tinkersConstructSection = "Tinkers' Construct";
   public static final String extraUtilitiesSection = "Extra Utilities";
   public static final String buildCraftSection = "BuildCraft";

   // Options in the config
   public static boolean doDebug = false;
   public static boolean enableStarryApple = true;
   public static boolean miningWorldHasCeiling = false;
   public static int miningWorldDimensionId = 6;
   public static boolean customBopHighlandsIntegration = true;
   public static boolean experimentalBopHighlandsIntegration = false;
   public static boolean thaumcraftHighlandsIntegration = true;
   public static boolean thaumcraftBiomeDictionary = true;
   public static int antiWitherPotionId = 35;
   public static boolean progressiveAutomationToolOverride = true;
   public static boolean enableGreenHeartCanister = true;
   public static boolean enableGreenHeartWitherDrop = true;
   public static boolean enableBedrockiumTools = true;
   public static boolean unbreakableEtherealTools = true;
   public static boolean buildCraftHighlandsIntegration = true;
   
   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      doDebug = config.getBoolean("Debug Information",generalSection, doDebug, "");
      enableStarryApple = config.getBoolean("Enable Starry Apple",generalSection, enableStarryApple, "");
      antiWitherPotionId = config.getInt("Anti-Wither Potion ID", generalSection, antiWitherPotionId, 24, 255, "Set to -1 to attempt an auto-assignment (experimental)");
      
      miningWorldHasCeiling = config.getBoolean("Has Ceiling", miningWorldSection, miningWorldHasCeiling, "Experimental, can cause severe lag");
      miningWorldDimensionId = config.get(miningWorldSection, "Dimension ID", miningWorldDimensionId, "").getInt(miningWorldDimensionId);
      
      customBopHighlandsIntegration = config.getBoolean("Highlands Integration",biomesOPlentySection, customBopHighlandsIntegration, "Register only specific biomes");
      experimentalBopHighlandsIntegration = config.getBoolean("Experimental Highlands Integration",biomesOPlentySection, experimentalBopHighlandsIntegration, "Experimental, can cause corrupt chunks");
      
      thaumcraftBiomeDictionary = config.getBoolean("Biome Dictionary",thaumcraftSection, thaumcraftBiomeDictionary, "Registers biomes to Biome Dictionary");
      
      progressiveAutomationToolOverride = config.getBoolean("Progressive Automation Tool Override",progressiveAutomationSection, progressiveAutomationToolOverride, "");
      
      enableGreenHeartCanister = config.getBoolean("Enable Green Heart Canister Crafting",tinkersConstructSection, enableGreenHeartCanister, "");
      enableGreenHeartWitherDrop = config.getBoolean("Enable Withers Dropping Green Hearts",tinkersConstructSection, enableGreenHeartWitherDrop, "");
      
      enableBedrockiumTools = config.getBoolean("Add Bedrockium Tools",extraUtilitiesSection, enableBedrockiumTools, "");
      unbreakableEtherealTools = config.getBoolean("Make Ethereal Tools Actually unbreakable",extraUtilitiesSection, unbreakableEtherealTools, "They will no longer be able to be enchanted");
      
      buildCraftHighlandsIntegration = config.getBoolean("Highlands Integration",buildCraftSection, buildCraftHighlandsIntegration, "Registers BuildCraft biomes with Highlands");
      
      config.save();
   }
}
