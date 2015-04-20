package main.feedthecreepertweaks.modhandlers;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;
import buildcraft.BuildCraftEnergy;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeEntry;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeRegistry;

public class BuildCraftHandler
{
   public static void init(FMLInitializationEvent event)
   {
      if(ConfigHandler.buildCraftHighlandsIntegration)
      {
         highlandsCompatibilty();
      }
   }
   
   private static void highlandsCompatibilty()
   {
      String modName = "BuildCraft";
      
      AdvancedBiomeEntry biomeOilDesert = new AdvancedBiomeEntry( BuildCraftEnergy.biomeOilDesert, 2, modName);
      AdvancedBiomeRegistry.addBiome(biomeOilDesert, "hot", true);

      AdvancedBiomeEntry biomeTaint = new AdvancedBiomeEntry(BuildCraftEnergy.biomeOilOcean, 2, modName);
      AdvancedBiomeRegistry.addBiome(biomeTaint, "ocean", true);
      
      
   }
}
