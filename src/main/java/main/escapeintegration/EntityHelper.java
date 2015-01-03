package main.escapeintegration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHelper
{
   private static BiomeGenBase[] allBiomes = getVanillaZombieBiomes();
   public static void adjustEntities()
   {
      // Hostile Worlds Customizations
      
      EntityRegistry.removeSpawn("HostileWorlds.HungryZombie", EnumCreatureType.monster, allBiomes);
      
      EntityRegistry.addSpawn("HostileWorlds.InvaderZombieMiner", ConfigHandler.minerZombieWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("HostileWorlds.ClimberZombie", ConfigHandler.climbingZombieWeight, 1, 1, EnumCreatureType.monster, allBiomes);   
      
      // Mo' Zombies Customizations
      
      EntityRegistry.removeSpawn("ZombieNotch", EnumCreatureType.monster, allBiomes);
      EntityRegistry.removeSpawn("ZombieHerobrine", EnumCreatureType.monster, allBiomes);
      
      EntityRegistry.addSpawn("ZombieMiner", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieChef", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieCreeper", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombiePirate", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombiePa", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieCyborg", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieDwarf", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieHerobrine", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieKing", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieMiner", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("ZombieKnight", ConfigHandler.moZombiesWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("DiscoZombie", ConfigHandler.moZombiesWeight, 2, 2, EnumCreatureType.monster, allBiomes);
      
      EntityRegistry.addSpawn("Survivor", ConfigHandler.moSurvivorWeight, 1, 2, EnumCreatureType.creature, allBiomes);
      
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
   
   private static BiomeGenBase[] getVanillaZombieBiomes()
   {
      BiomeGenBase[] biomes = {};
      for(BiomeGenBase biome : getSafeAllBiomeArray())
      {
         List<SpawnListEntry> spawns = biome.getSpawnableList(EnumCreatureType.monster);
         for( SpawnListEntry entry : spawns)
         {
            if( entry.toString().contains("EntityZombie*") )
            {
               biomes = ArrayUtils.add(biomes, biome);
            }
         }
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
         EscapeIntegration.logger.debug("Entity Name: " + entityName );         
      }
      EscapeIntegration.logger.debug("Forest Spawn List");
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
         EscapeIntegration.logger.debug(entry.toString());
      }
   }
   
}
