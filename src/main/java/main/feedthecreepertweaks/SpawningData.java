package main.feedthecreepertweaks;

import java.util.HashMap;
import java.util.LinkedList;

class SpawningData
{
   private static class SpawnInfo
   {
      public int weight = 0;
      public int minGroup = 0;
      public int maxGroup = 0;
      
      @Override
      public boolean equals(Object obj)
      {
         if( obj instanceof SpawnInfo )
         {
            SpawnInfo other = (SpawnInfo)obj;
            return other.weight == this.weight && other.minGroup == this.minGroup && other.maxGroup == this.maxGroup;                  
         }
         return false;
      }
      @Override
      public int hashCode()
      {
         return weight << 16 + minGroup << 8 + maxGroup;
      }
      @Override
      public String toString()
      {
         return "Weight: " + weight + " Min: " + minGroup + " Max: " + maxGroup;
      }
   }
   
   private static HashMap<String, HashMap<SpawnInfo, LinkedList[]>> spawnData;
   
   private static SpawningData instance = new SpawningData();
      
   private SpawningData()
   {
      
   }
   
   public static SpawningData GetSpawningData()
   {
      return instance;
   }
}
