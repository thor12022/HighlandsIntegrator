package main.escapeintegration.util;

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
import main.escapeintegration.ConfigHandler;
import main.escapeintegration.EscapeIntegration;
import main.escapeintegration.ModInformation;

public class EventHandler
{

   @SubscribeEvent
   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
   {
      if(eventArgs.modID.equals(ModInformation.ID))
      {
         ConfigHandler.syncConfig();
         EscapeIntegration.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
      }
   }

   @SubscribeEvent
   public void onFoodStartEating(PlayerUseItemEvent.Start event)
   {
      if(event.item.getItem() instanceof ItemFood)
      {
         event.entityPlayer.addChatMessage(new ChatComponentTranslation("info." + ModInformation.ID + ".chat.food"));
         event.duration = 0;
      }
   }

}
