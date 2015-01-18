package main.feedthecreepertweaks.modhandlers;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;
import thaumcraft.common.lib.world.ThaumcraftWorldGenerator;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeEntry;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeRegistry;

public class ThaumcraftHandler
{
   public static void init(FMLInitializationEvent event)
   {
      biomeDictionary();
      highlandsCompatibilty();
   }
   
   private static void highlandsCompatibilty()
   {
      String modName = "Thaumcraft";
      
      AdvancedBiomeEntry biomeMagicalForest = new AdvancedBiomeEntry(ThaumcraftWorldGenerator.biomeMagicalForest, thaumcraft.common.config.Config.biomeMagicalForestWeight, modName);
      AdvancedBiomeRegistry.addBiome(biomeMagicalForest, "warm", true);
      AdvancedBiomeRegistry.addBiome(biomeMagicalForest, "cool", true);

      AdvancedBiomeEntry biomeTaint = new AdvancedBiomeEntry(ThaumcraftWorldGenerator.biomeTaint, thaumcraft.common.config.Config.biomeTaintWeight, modName);
      AdvancedBiomeRegistry.addBiome(biomeTaint, "warm", true);
      AdvancedBiomeRegistry.addBiome(biomeTaint, "cool", true);
   }
   
   private static void biomeDictionary()
   {     
      BiomeDictionary.makeBestGuess(ThaumcraftWorldGenerator.biomeMagicalForest);
      BiomeDictionary.registerBiomeType(ThaumcraftWorldGenerator.biomeMagicalForest, BiomeDictionary.Type.MAGICAL);
      
      BiomeDictionary.makeBestGuess(ThaumcraftWorldGenerator.biomeTaint);
      BiomeDictionary.registerBiomeType(ThaumcraftWorldGenerator.biomeTaint, BiomeDictionary.Type.MAGICAL);
      BiomeDictionary.makeBestGuess(ThaumcraftWorldGenerator.biomeEerie);
      BiomeDictionary.registerBiomeType(ThaumcraftWorldGenerator.biomeEerie, BiomeDictionary.Type.MAGICAL);
      
      BiomeDictionary.makeBestGuess(ThaumcraftWorldGenerator.biomeEldritchLands);
      BiomeDictionary.registerBiomeType(ThaumcraftWorldGenerator.biomeEldritchLands, BiomeDictionary.Type.MAGICAL);
   }
}
