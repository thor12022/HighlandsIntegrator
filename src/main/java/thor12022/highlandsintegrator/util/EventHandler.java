package thor12022.highlandsintegrator.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import net.minecraft.util.ChatComponentTranslation;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import thor12022.highlandsintegrator.ConfigHandler;
import thor12022.highlandsintegrator.HighlandsIntegrator;
import thor12022.highlandsintegrator.ModInformation;

public class EventHandler
{

   @SubscribeEvent
   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
   {
      if(eventArgs.modID.equals(ModInformation.ID))
      {
         ConfigHandler.syncConfig();
         HighlandsIntegrator.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
      }
   }
}
