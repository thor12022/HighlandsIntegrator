package main.feedthecreepertweaks.modhandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tconstruct.armor.TinkerArmor;
import tconstruct.util.ItemHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import main.feedthecreepertweaks.ModInformation;
import main.feedthecreepertweaks.potions.PotionAntiWither;
import main.feedthecreepertweaks.potions.PotionRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class TinkersConstructHandler
{
   private static TinkersConstructHandler eventHandler = new TinkersConstructHandler();
   
   private TinkersConstructHandler()
   {
      MinecraftForge.EVENT_BUS.register(this);
   }
   
   public static void init(FMLInitializationEvent event)
   {
      if(ConfigHandler.enableGreenHeartCanister)
      {
         GameRegistry.addShapelessRecipe( new ItemStack(TinkerArmor.heartCanister, 1, 6), 
                                          new ItemStack(TinkerArmor.heartCanister, 1, 4), 
                                          new ItemStack(TinkerArmor.heartCanister, 1, 5), 
                                          new ItemStack(Items.nether_star));
      }
   }
   
   @SubscribeEvent
   public void onLivingDrop (LivingDropsEvent event)
   {
       if (!ConfigHandler.enableGreenHeartWitherDrop || !event.recentlyHit)
       {
          return;
       }
       //FeedTheCreeperTweaks.logger.debug("EntityLiving Dropping something");
       if (event.entityLiving != null && event.entityLiving.getClass() == EntityWither.class)
       {
          //FeedTheCreeperTweaks.logger.debug("It was a Wither");
          if(event.source.damageType.equals("player"))
          {
             //FeedTheCreeperTweaks.logger.debug("A Player did it");
             EntityPlayer killerPlayer = (EntityPlayer)event.source.getEntity();
             PotionEffect antiWitherEffect = killerPlayer.getActivePotionEffect(PotionRegistry.potionAntiWither);
             if( antiWitherEffect != null )
             {
                //FeedTheCreeperTweaks.logger.debug("They used Anti-Wither!");
                if(PotionAntiWither.HasEntityBeenWithered(killerPlayer))
                {
                   //FeedTheCreeperTweaks.logger.debug("They were withered!");
                   Random rand = new Random();
                   int numberOfHearts = 0;
                   for( int lootingLevel = event.lootingLevel; lootingLevel >= 0; --lootingLevel)
                   {
                      numberOfHearts += rand.nextInt(2);
                   }
                   ItemHelper.addDrops(event, new ItemStack(TinkerArmor.heartCanister, numberOfHearts, 5));
                   FeedTheCreeperTweaks.logger.debug("Withered Anti-Withered Player killed Wither, dropping Miniture" + numberOfHearts + " Green Hearts");
                }
             }
             
          }
       }
    }
}
