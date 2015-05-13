package thor12022.highlandsintegrator.modhandlers;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import thor12022.highlandsintegrator.ConfigHandler;
import thor12022.highlandsintegrator.HighlandsIntegrator;
import thor12022.highlandsintegrator.ModInformation;
import thor12022.highlandsintegrator.util.TextHelper;
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
	  HighlandsIntegrator.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init.buildcraft"));
		  
	  String modName = "BuildCraft";
      
      AdvancedBiomeEntry biomeOilDesert = new AdvancedBiomeEntry( BuildCraftEnergy.biomeOilDesert, ConfigHandler.buildCraftDesertOilFieldsWeight, modName);
      AdvancedBiomeRegistry.addBiome(biomeOilDesert, "hot", true);

      AdvancedBiomeEntry biomeTaint = new AdvancedBiomeEntry(BuildCraftEnergy.biomeOilOcean, ConfigHandler.buildCraftOceanOilFieldsWeight, modName);
      AdvancedBiomeRegistry.addBiome(biomeTaint, "ocean", true);
      
      
   }
}
