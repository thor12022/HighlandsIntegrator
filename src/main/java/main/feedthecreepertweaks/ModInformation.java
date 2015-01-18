package main.feedthecreepertweaks;

/*
 * Basic information your mod depends on.
 */

public class ModInformation
{

   public static final String NAME = "Feed the Creeper Tweaks";
   public static final String ID = "feedthecreepertweaks";
   public static final String CHANNEL = "FeedTheCreeperTweaks";
   public static final String DEPEND = "required-after:Thaumcraft;required-after:Highlands";
   public static final String VERSION = "0.0.1";
   public static final String CLIENTPROXY = "main.feedthecreepertweaks.proxies.ClientProxy";
   public static final String COMMONPROXY = "main.feedthecreepertweaks.proxies.CommonProxy";
   public static final String GUIFACTORY = "main.feedthecreepertweaks.client.gui.ConfigGuiFactory";
}
