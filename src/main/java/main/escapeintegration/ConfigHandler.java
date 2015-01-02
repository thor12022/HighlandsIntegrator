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

   // Options in the config
   public static int minerZombieWeight = 1;
   public static int climbingZombieWeight = 1;

   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      config.addCustomCategoryComment(entitySection, "");

      minerZombieWeight = config.get(entitySection, "Miner Zombie Weight", minerZombieWeight, "").getInt(minerZombieWeight);
      climbingZombieWeight = config.get(entitySection, "Climbing Zombie Weight", climbingZombieWeight, "").getInt(climbingZombieWeight);

      config.save();
   }
}
