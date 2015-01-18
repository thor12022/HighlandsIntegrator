package main.feedthecreepertweaks.modhandlers;


import net.minecraft.world.biome.BiomeGenBase;
import biomesoplenty.api.content.BOPCBiomes;
import biomesoplenty.common.configuration.BOPConfigurationBiomeWeights;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeEntry;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeRegistry;
import highlands.Initializer;
import highlands.biome.BiomeGenBaseHighlands;
import highlands.api.HighlandsBiomes;

public class BiomesOPlentyHandler
{
   public static void init(FMLInitializationEvent event)
   {
      highlandsCompatibilty();
   }
   
   private static void highlandsCompatibilty()
   {
      String modName = "BiomesOPlenty";
      
      // Alps disabled
      
      AdvancedBiomeEntry alpsForest = new AdvancedBiomeEntry(BOPCBiomes.alpsForest, 10, modName);
      AdvancedBiomeRegistry.addBiome(alpsForest, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(BOPCBiomes.alpsForest, HighlandsBiomes.alps);
      
      // Artic disabled
      
      AdvancedBiomeEntry bambooForest = new AdvancedBiomeEntry(BOPCBiomes.bambooForest, 5, modName);
      AdvancedBiomeRegistry.addBiome(bambooForest, "hot", true);

      AdvancedBiomeEntry bayou = new AdvancedBiomeEntry(BOPCBiomes.bayou, 10, modName);
      AdvancedBiomeRegistry.addBiome(bayou, "warm", true);

      AdvancedBiomeEntry bog = new AdvancedBiomeEntry(BOPCBiomes.bog, 7, modName);
      AdvancedBiomeRegistry.addBiome(bog, "warm", true);

      // Boreal Forest disabled
      
      // Brushland disabled
      
      AdvancedBiomeEntry canyon = new AdvancedBiomeEntry(BOPCBiomes.canyon, 7, modName);
      AdvancedBiomeRegistry.addBiome(canyon, "hot", true);
      
      // Chaparral disabled

      AdvancedBiomeEntry cherryBlossomGrove = new AdvancedBiomeEntry(BOPCBiomes.cherryBlossomGrove, 3, modName);
      AdvancedBiomeRegistry.addBiome(cherryBlossomGrove, "cool", true);

      AdvancedBiomeEntry coniferousForest = new AdvancedBiomeEntry(BOPCBiomes.coniferousForest, 10, modName);
      AdvancedBiomeRegistry.addBiome(coniferousForest, "warm", true); 

      // Snowy coniferous forest disabled
      
      AdvancedBiomeEntry crag = new AdvancedBiomeEntry(BOPCBiomes.crag, 3, modName);
      AdvancedBiomeRegistry.addBiome(crag, "cool", true); 

      AdvancedBiomeEntry deadForest = new AdvancedBiomeEntry(BOPCBiomes.deadForest, 7, modName);
      AdvancedBiomeRegistry.addBiome(deadForest, "cool", true); 

      AdvancedBiomeEntry deadSwamp = new AdvancedBiomeEntry(BOPCBiomes.deadSwamp, 7, modName);
      AdvancedBiomeRegistry.addBiome(deadSwamp, "warm", true); 

      AdvancedBiomeEntry deciduousForest = new AdvancedBiomeEntry(BOPCBiomes.deciduousForest, 10, modName);
      AdvancedBiomeRegistry.addBiome(deciduousForest, "warm", true); 

      AdvancedBiomeEntry fen = new AdvancedBiomeEntry(BOPCBiomes.fen, 10, modName);
      AdvancedBiomeRegistry.addBiome(fen, "warm", true);

      AdvancedBiomeEntry flowerField = new AdvancedBiomeEntry(BOPCBiomes.flowerField, 3, modName);
      AdvancedBiomeRegistry.addBiome(flowerField, "warm", true);

      AdvancedBiomeEntry frostForest = new AdvancedBiomeEntry(BOPCBiomes.frostForest, 7, modName);
      AdvancedBiomeRegistry.addBiome(frostForest, "icy", true);

      AdvancedBiomeEntry fungiForest = new AdvancedBiomeEntry(BOPCBiomes.fungiForest, 3, modName);
      AdvancedBiomeRegistry.addBiome(fungiForest, "cool", true);

      AdvancedBiomeEntry garden = new AdvancedBiomeEntry(BOPCBiomes.garden, 3, modName);
      AdvancedBiomeRegistry.addBiome(garden, "cool", true);
      
      // Grassland disabled
      
      // Grove disabled

      AdvancedBiomeEntry heathland = new AdvancedBiomeEntry(BOPCBiomes.heathland, 10, modName);
      AdvancedBiomeRegistry.addBiome(heathland, "warm", true);
      
      AdvancedBiomeEntry highland = new AdvancedBiomeEntry(BOPCBiomes.highland, 10, modName);
      AdvancedBiomeRegistry.addBiome(highland, "warm", true);

      // Jade Cliff disabled
      //AdvancedBiomeEntry jadeCliffs = new AdvancedBiomeEntry(BOPCBiomes.jadeCliffs, 5, modName);
      //AdvancedBiomeRegistry.addBiome(jadeCliffs, "warm", true);

      AdvancedBiomeEntry lavenderFields = new AdvancedBiomeEntry(BOPCBiomes.lavenderFields, 3, modName);
      AdvancedBiomeRegistry.addBiome(lavenderFields, "warm", true);

      AdvancedBiomeEntry lushDesert = new AdvancedBiomeEntry(BOPCBiomes.lushDesert, 5, modName);
      AdvancedBiomeRegistry.addBiome(lushDesert, "hot", true);

      AdvancedBiomeEntry lushSwamp = new AdvancedBiomeEntry(BOPCBiomes.lushSwamp, 10, modName);
      AdvancedBiomeRegistry.addBiome(lushSwamp, "warm", true);

      AdvancedBiomeEntry mapleWoods = new AdvancedBiomeEntry(BOPCBiomes.mapleWoods, 10, modName);
      AdvancedBiomeRegistry.addBiome(mapleWoods, "cool", true);

      AdvancedBiomeEntry marsh = new AdvancedBiomeEntry(BOPCBiomes.marsh, 7, modName);
      AdvancedBiomeRegistry.addBiome(marsh, "warm", true);
      
      // Meadow disabled

      AdvancedBiomeEntry moor = new AdvancedBiomeEntry(BOPCBiomes.moor, 10, modName);
      AdvancedBiomeRegistry.addBiome(moor, "cool", true);

      AdvancedBiomeEntry mountain = new AdvancedBiomeEntry(BOPCBiomes.mountain, 10, modName);
      AdvancedBiomeRegistry.addBiome(mountain, "warm", true);

      AdvancedBiomeEntry mysticGrove = new AdvancedBiomeEntry(BOPCBiomes.mysticGrove, 3, modName);
      AdvancedBiomeRegistry.addBiome(mysticGrove, "warm", true);

      AdvancedBiomeEntry ominousWoods = new AdvancedBiomeEntry(BOPCBiomes.ominousWoods, 3, modName);
      AdvancedBiomeRegistry.addBiome(ominousWoods, "cool", true);

      AdvancedBiomeEntry originValley = new AdvancedBiomeEntry(BOPCBiomes.originValley, 1, modName);
      AdvancedBiomeRegistry.addBiome(originValley, "warm", true);
      
      AdvancedBiomeEntry outback = new AdvancedBiomeEntry(BOPCBiomes.outback, 7, modName);
      AdvancedBiomeRegistry.addBiome(outback, "hot", true);

      AdvancedBiomeEntry prairie = new AdvancedBiomeEntry(BOPCBiomes.prairie, 10, modName);
      AdvancedBiomeRegistry.addBiome(prairie, "warm", true);

      // Rainforest disabled
      
      // Redwood Forest disabled
      
      AdvancedBiomeEntry sacredSprings = new AdvancedBiomeEntry(BOPCBiomes.sacredSprings, 3, modName);
      AdvancedBiomeRegistry.addBiome(sacredSprings, "warm", true);

      AdvancedBiomeEntry seasonalForest = new AdvancedBiomeEntry(BOPCBiomes.seasonalForest, 10, modName);
      AdvancedBiomeRegistry.addBiome(seasonalForest, "cool", true);

      AdvancedBiomeEntry shield = new AdvancedBiomeEntry(BOPCBiomes.shield, 7, modName);
      AdvancedBiomeRegistry.addBiome(shield, "cool", true);

      AdvancedBiomeEntry shrubland = new AdvancedBiomeEntry(BOPCBiomes.shrubland, 10, modName);
      AdvancedBiomeRegistry.addBiome(shrubland, "cool", true);

      AdvancedBiomeEntry sludgepit = new AdvancedBiomeEntry(BOPCBiomes.sludgepit, 5, modName);
      AdvancedBiomeRegistry.addBiome(sludgepit, "warm", true);

      // Steppe disabled
      
      AdvancedBiomeEntry temperateRainforest = new AdvancedBiomeEntry(BOPCBiomes.temperateRainforest, 10, modName);
      AdvancedBiomeRegistry.addBiome(temperateRainforest, "warm", true);

      AdvancedBiomeEntry thicket = new AdvancedBiomeEntry(BOPCBiomes.thicket, 5, modName);
      AdvancedBiomeRegistry.addBiome(thicket, "cool", true);

      AdvancedBiomeEntry tropicalRainforest = new AdvancedBiomeEntry(BOPCBiomes.tropicalRainforest, 5, modName);
      AdvancedBiomeRegistry.addBiome(tropicalRainforest, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(tropicalRainforest, HighlandsBiomes.tropics);

      AdvancedBiomeEntry tundra = new AdvancedBiomeEntry(BOPCBiomes.tundra, 7, modName);
      AdvancedBiomeRegistry.addBiome(tundra, "icy", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(BOPCBiomes.tundra, HighlandsBiomes.alps);
      AdvancedBiomeRegistry.addSubBiomeToBiome(BOPCBiomes.tundra, HighlandsBiomes.tallPineForest);


      AdvancedBiomeEntry volcano = new AdvancedBiomeEntry(BOPCBiomes.volcano, 1, modName);
      AdvancedBiomeRegistry.addBiome(volcano, "hot", true);
      
      AdvancedBiomeEntry wasteland = new AdvancedBiomeEntry(BOPCBiomes.wasteland, 3, modName);
      AdvancedBiomeRegistry.addBiome(wasteland, "hot", true);

      AdvancedBiomeEntry wetland = new AdvancedBiomeEntry(BOPCBiomes.wetland, 7, modName);
      AdvancedBiomeRegistry.addBiome(wetland, "warm", true);

      AdvancedBiomeEntry woodland = new AdvancedBiomeEntry(BOPCBiomes.woodland, 10, modName);
      AdvancedBiomeRegistry.addBiome(woodland, "warm", true);

      

      AdvancedBiomeEntry coralReef = new AdvancedBiomeEntry(BOPCBiomes.coralReef, 10, modName);
      AdvancedBiomeRegistry.addBiome(wasteland, "ocean", true);

      AdvancedBiomeEntry kelpForest = new AdvancedBiomeEntry(BOPCBiomes.kelpForest, 10, modName);
      AdvancedBiomeRegistry.addBiome(kelpForest, "ocean", true);

      AdvancedBiomeEntry tropics = new AdvancedBiomeEntry(BOPCBiomes.tropics, 10, modName);
      AdvancedBiomeRegistry.addBiome(tropics, "ocean", true);

      AdvancedBiomeEntry volcanoIsland = new AdvancedBiomeEntry(BOPCBiomes.volcano, 10, modName);
      AdvancedBiomeRegistry.addBiome(volcanoIsland, "ocean", true);
      
      // Mangrove disabled

      AdvancedBiomeEntry canyonRavine = new AdvancedBiomeEntry(BOPCBiomes.canyonRavine, 10, modName);
      AdvancedBiomeRegistry.addBiome(canyonRavine, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(canyonRavine, BOPCBiomes.canyon);

      // Glacier disabled
      
      // Meadow Forest disabled

      AdvancedBiomeEntry oasis = new AdvancedBiomeEntry(BOPCBiomes.oasis, 10, modName);
      AdvancedBiomeRegistry.addBiome(oasis, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(oasis, BiomeGenBase.desert);

      AdvancedBiomeEntry orchard = new AdvancedBiomeEntry(BOPCBiomes.orchard, 10, modName);
      AdvancedBiomeRegistry.addBiome(orchard, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(orchard, BiomeGenBase.plains);

      AdvancedBiomeEntry quagmire = new AdvancedBiomeEntry(BOPCBiomes.quagmire, 10, modName);
      AdvancedBiomeRegistry.addBiome(quagmire, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(quagmire, BOPCBiomes.sludgepit);

      AdvancedBiomeEntry scrubland = new AdvancedBiomeEntry(BOPCBiomes.scrubland, 10, modName);
      AdvancedBiomeRegistry.addBiome(scrubland, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(scrubland, BiomeGenBase.savanna);

      AdvancedBiomeEntry silkglades = new AdvancedBiomeEntry(BOPCBiomes.silkglades, 10, modName);
      AdvancedBiomeRegistry.addBiome(silkglades, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(silkglades, BOPCBiomes.sludgepit);

      AdvancedBiomeEntry spruceWoods = new AdvancedBiomeEntry(BOPCBiomes.spruceWoods, 10, modName);
      AdvancedBiomeRegistry.addBiome(spruceWoods, "sub", true);
      AdvancedBiomeRegistry.addSubBiomeToBiome(spruceWoods, BiomeGenBase.forest);   
      
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.lushSwamp);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.lavenderFields);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.flowerField);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.bambooForest);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.cherryBlossomGrove);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.lushDesert);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BOPCBiomes.spruceWoods);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BiomeGenBase.forest);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BiomeGenBase.forestHills);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BiomeGenBase.jungle);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BiomeGenBase.jungleEdge);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, BiomeGenBase.jungleHills);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, HighlandsBiomes.flyingMountains);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, HighlandsBiomes.birchHills);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, HighlandsBiomes.rainforest);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, HighlandsBiomes.tropics);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.lushRiver, HighlandsBiomes.woodlands);
      
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.dryRiver, BOPCBiomes.outback);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.dryRiver, BiomeGenBase.desert);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.dryRiver, BiomeGenBase.desertHills);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.dryRiver, HighlandsBiomes.desertMountains);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.dryRiver, HighlandsBiomes.dunes);
      AdvancedBiomeRegistry.setRiverBiomeToBiome(BOPCBiomes.dryRiver, HighlandsBiomes.outback);
   }
}
