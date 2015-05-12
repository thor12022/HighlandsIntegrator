package thor12022.highlandsintegrator.modhandlers;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import thor12022.highlandsintegrator.ConfigHandler;
import thor12022.highlandsintegrator.HighlandsIntegrator;
import thor12022.highlandsintegrator.ModInformation;
import thor12022.highlandsintegrator.util.TextHelper;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;
import thaumcraft.common.lib.world.ThaumcraftWorldGenerator;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeEntry;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeRegistry;

public class ThaumcraftHandler
{
   public static void init(FMLInitializationEvent event)
   {
      if(ConfigHandler.thaumcraftHighlandsIntegration)
      {
         highlandsCompatibilty();
      }
   }
   
   private static void highlandsCompatibilty()
   {
	  HighlandsIntegrator.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init.thaumcraft"));
	  
      String modName = "Thaumcraft";
      
      AdvancedBiomeEntry biomeMagicalForest = new AdvancedBiomeEntry(ThaumcraftWorldGenerator.biomeMagicalForest, thaumcraft.common.config.Config.biomeMagicalForestWeight, modName);
      AdvancedBiomeRegistry.addBiome(biomeMagicalForest, "warm", true);
      AdvancedBiomeRegistry.addBiome(biomeMagicalForest, "cool", true);

      AdvancedBiomeEntry biomeTaint = new AdvancedBiomeEntry(ThaumcraftWorldGenerator.biomeTaint, thaumcraft.common.config.Config.biomeTaintWeight, modName);
      AdvancedBiomeRegistry.addBiome(biomeTaint, "warm", true);
      AdvancedBiomeRegistry.addBiome(biomeTaint, "cool", true);
   }
}
