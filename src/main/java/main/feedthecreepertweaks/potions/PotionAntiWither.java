package main.feedthecreepertweaks.potions;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import tconstruct.armor.TinkerArmor;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

public class PotionAntiWither extends Potion
{
   public static int id;
   private static final Map<EntityLivingBase,Integer> affectedEntities = Maps.newHashMap();
   private static final Set<EntityLivingBase> affectedWitheredEntities = Sets.newHashSet();
   
   public PotionAntiWither( int id )
   {
      super( id, false, 1310740);
      this.setIconIndex(1, 0);
      MinecraftForge.EVENT_BUS.register(this);
   }
   
   public static boolean HasEntityBeenWithered(EntityLivingBase entity)
   {
      return affectedWitheredEntities.contains(entity);
   }
   
   @Override
   public void applyAttributesModifiersToEntity(EntityLivingBase entityLiving, BaseAttributeMap map, int par3) 
   {
      if( !affectedEntities.containsKey(entityLiving))
      {
         affectedEntities.put(entityLiving, -1);
      }
   }

   @Override
   public void removeAttributesModifiersFromEntity(EntityLivingBase entityLiving, BaseAttributeMap map, int par3)
   {
      if(affectedEntities.containsKey(entityLiving))
      {
         affectedEntities.remove(entityLiving);
      }
      if(affectedWitheredEntities.contains(entityLiving))
      {
         affectedWitheredEntities.remove(entityLiving);
      }
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public int getStatusIconIndex()
   {
      Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(ModInformation.ID + ":textures/guis/icons.png"));
      return 1;
   }
   
   @SubscribeEvent
   public void onEntityUpdate(LivingUpdateEvent event) 
   {
      PotionEffect antiWitherEffect = event.entityLiving.getActivePotionEffect(this);
      if(antiWitherEffect != null)
      {
         PotionEffect witherEffect = event.entityLiving.getActivePotionEffect(Potion.wither);
         if(witherEffect != null)
         {
            if( !affectedEntities.containsKey(event.entityLiving))
            {
               affectedEntities.put(event.entityLiving, -1);
            }
            if( witherEffect.getDuration() > affectedEntities.get(event.entityLiving) )
            {
               int newDuration = ( witherEffect.getDuration() - affectedEntities.get(event.entityLiving) ) / ( 2 * (antiWitherEffect.getAmplifier() + 1));
               FeedTheCreeperTweaks.logger.debug("Anti-Wither reducing Wither effect to " + newDuration/20 + " seconds for " + event.entityLiving.getCommandSenderName());
               int amplifier = witherEffect.getAmplifier();
               event.entityLiving.removePotionEffect(Potion.wither.id);
               event.entityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, newDuration, amplifier));
               affectedEntities.put(event.entityLiving, newDuration);
               affectedWitheredEntities.add(event.entityLiving);
            }
            else
            {
               affectedEntities.put(event.entityLiving, witherEffect.getDuration());
            }
         }
      }
   }
      
   
}
