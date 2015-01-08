package main.feedthecreepertweaks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHelper
{
   private static BiomeGenBase[] allBiomes;
   private static BiomeGenBase[] zombieBiomes;
   
   private static int zombieSpawnWeight;
   private static int zombieMinGroupSize;
   private static int zombieMaxGroupSize;
  
   public static void init()
   {
      allBiomes = getSafeAllBiomeArray();
      zombieBiomes = getVanillaZombieInfo(zombieSpawnWeight, zombieMinGroupSize, zombieMaxGroupSize);
   }
   
   public static void adjustEntities()
   {
      // Vanilla Customizations
   }

   private static BiomeGenBase[] getSafeAllBiomeArray()
   {
      BiomeGenBase[] biomes = {};
      for( BiomeGenBase biome : BiomeGenBase.getBiomeGenArray() )
      {
         try
         {
            int biomeId = biome.biomeID;
            biomes = ArrayUtils.add(biomes, biome);
         }
         catch(NullPointerException e)
         {}
      }
      return biomes;
   }
   
   private static BiomeGenBase[] getVanillaZombieInfo(int weight, int min, int max)
   {
      weight = 0;
      min = 0;
      max = 0;
      int entryNumber = 0;
      BiomeGenBase[] biomes = {};
      for(BiomeGenBase biome : allBiomes)
      {
         List<SpawnListEntry> spawns = biome.getSpawnableList(EnumCreatureType.monster);
         for( SpawnListEntry entry : spawns)
         {
            if( entry.toString().contains("EntityZombie*") )
            {
               entryNumber++;
               min += entry.minGroupCount;
               max += entry.maxGroupCount;
               weight += entry.itemWeight;
               biomes = ArrayUtils.add(biomes, biome);
            }
         }
         if(entryNumber > 0)
         {
            min /= entryNumber;
            max /= entryNumber;
            weight /= entryNumber;
         }
      }
      if(ConfigHandler.doDebug)
      {
         String biomesString = "[" ;
         for(BiomeGenBase biome : biomes)
         {
            biomesString += biome.biomeName;
            biomesString += ", ";
         }
         biomesString = biomesString.substring(0, biomesString.lastIndexOf(',') - 1) + "]";
         FeedTheCreeperTweaks.logger.debug("Vanilla Zombie spawnable biomes: " + biomesString );      
      }
      return biomes;
   }
   
   public static void debugInformation()
   {
      for( Object string : EntityList.stringToClassMapping.keySet())
      {
         String entityName = (String)string;
         Class entityClass = (Class)EntityList.stringToClassMapping.get(entityName);
         EntityRegistry.EntityRegistration entityInfo = EntityRegistry.instance().lookupModSpawn(entityClass, false);
         FeedTheCreeperTweaks.logger.debug("Entity Name: " + entityName );         
      }
      FeedTheCreeperTweaks.logger.debug("Forest Spawn List");
      HashMap<String, HashSet<String>> spawningData = new HashMap();
      for(BiomeGenBase biome : allBiomes)
      {
         List<SpawnListEntry> spawns = biome.getSpawnableList(EnumCreatureType.monster);
         for( SpawnListEntry entry : spawns)
         {
            if( spawningData.containsKey(entry.toString()) )
            {
               HashSet<String> spawnBiomes = spawningData.get(entry.toString());
               spawnBiomes.add(biome.biomeName);
            }
            else
            {
               HashSet<String> spawnBiomes = new HashSet();
               spawnBiomes.add(biome.biomeName);
               spawningData.put(entry.toString(), spawnBiomes );
            }
         }
      }
      for(Map.Entry<String, HashSet<String>> entry: spawningData.entrySet())
      {
         FeedTheCreeperTweaks.logger.debug(entry.toString());
      }
   }
   
}
