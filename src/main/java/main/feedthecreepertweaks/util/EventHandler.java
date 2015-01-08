package main.feedthecreepertweaks.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import main.feedthecreepertweaks.ModInformation;

public class EventHandler
{

   @SubscribeEvent
   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
   {
      if(eventArgs.modID.equals(ModInformation.ID))
      {
         ConfigHandler.syncConfig();
         FeedTheCreeperTweaks.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
      }
   }
}
