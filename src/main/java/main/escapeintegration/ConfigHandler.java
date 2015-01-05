package main.escapeintegration;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{

   public static Configuration config;

   // Sections to add to the config
   public static String entitySection = "Entity Adjustments";
   public static String generalSection = "General";

   // Options in the config
   public static boolean doDebug = false;
   public static int minerZombieWeight = 1;
   public static int climbingZombieWeight = 1;
   public static int moZombiesWeight = 4;
   public static int moSurvivorWeight = 1;
   
   public static float mobSpawningWeightScale = 1.5f;

   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      config.addCustomCategoryComment(entitySection, "");

      doDebug = config.getBoolean(generalSection, "Debug Information", doDebug, "");
      
      minerZombieWeight = config.get(entitySection, "Miner Zombie Weight", minerZombieWeight, "").getInt(minerZombieWeight);
      climbingZombieWeight = config.get(entitySection, "Climbing Zombie Weight", climbingZombieWeight, "").getInt(climbingZombieWeight);
      moZombiesWeight = config.get(entitySection, "Mo' Zombies Weight", moZombiesWeight, "").getInt(moZombiesWeight);
      moSurvivorWeight = config.get(entitySection, "Mo' Survivor Weight", moSurvivorWeight, "").getInt(moSurvivorWeight);
      mobSpawningWeightScale = config.getFloat("Mob Spawning Weight Scale",entitySection, mobSpawningWeightScale, 0.1f, 100f, "Other mob wieghts will be scaled up by this");
      config.save();
   }
}
