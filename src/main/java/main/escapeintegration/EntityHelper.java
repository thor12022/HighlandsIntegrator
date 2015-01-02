package main.escapeintegration;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHelper
{
   private static BiomeGenBase[] allBiomes = getSafeBiomeArray();
   public static void adjustEntities()
   {
      EntityRegistry.addSpawn("HostileWorlds.InvaderZombieMiner", ConfigHandler.minerZombieWeight, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("HostileWorlds.ClimberZombie", ConfigHandler.climbingZombieWeight, 1, 1, EnumCreatureType.monster, allBiomes);   
   
      EntityRegistry.removeSpawn("com.coocoo617.entity.EntityZombieNotch", EnumCreatureType.monster, allBiomes);
      EntityRegistry.removeSpawn("com.coocoo617.entity.EntityZombieHerobrine", EnumCreatureType.monster, allBiomes);
      
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieMiner", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieChef", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieCreeper", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombiePirate", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombiePa", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieCyborg", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieDwarf", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieHerobrine", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieKing", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieMiner", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityZombieKnight", 1, 1, 1, EnumCreatureType.monster, allBiomes);
      EntityRegistry.addSpawn("com.coocoo617.entity.EntityDiscoZombie", 1, 2, 2, EnumCreatureType.monster, allBiomes);
      
      EntityRegistry.addSpawn("com.coocoo617.entity.EntitySurvivor", 1, 1, 4, EnumCreatureType.creature, allBiomes);
   }

   private static BiomeGenBase[] getSafeBiomeArray()
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
   
}
