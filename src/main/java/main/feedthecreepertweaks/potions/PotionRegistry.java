package main.feedthecreepertweaks.potions;

import biomesoplenty.common.helpers.BOPReflectionHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import net.minecraft.potion.Potion;

public class PotionRegistry
{
   public static Potion potionAntiWither;
   
   public static void registerPotions()
   {
      if(ConfigHandler.antiWitherPotionId == -1)
      {
         ConfigHandler.antiWitherPotionId = NextPotionId();
      }
      
      FeedTheCreeperTweaks.logger.debug("Assigning Potion ID " + ConfigHandler.antiWitherPotionId + " to Anti-Wither");
      potionAntiWither = new PotionAntiWither(ConfigHandler.antiWitherPotionId).setPotionName("potion.antiWither");
   }

   private static int NextPotionId()
   {
      for( int potionId = 34; potionId < Potion.potionTypes.length; potionId++ )
      {
         if( Potion.potionTypes[potionId] == null )
         {
            return potionId;
         }
      }
      return -1;
   }
}
