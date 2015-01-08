package main.feedthecreepertweaks.util;

//This class handles all generation the mod contains.

import cpw.mods.fml.common.IWorldGenerator;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.blocks.BlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class GenerationHandler implements IWorldGenerator
{

   // Which dimension to generate in by dimension ID (Nether -1, Overworld 0,
   // End 1, etc)
   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
   {
      switch(world.provider.dimensionId)
      {
      case 6:
         generateMiningWorld(world, random, chunkX * 16, chunkZ * 16);
         break;
      }
   }

   // The actual generation method.
   private void generateMiningWorld(World world, Random rand, int chunkX, int chunkZ)
   {
      for(int x = 0; x < 16; x++) 
      {
         for(int z = 0; z < 16; z++)
         {
            (new WorldGenMinable(Blocks.bedrock, 0)).generate(world, rand, x, 255, z);
         }
      }
   }
}
