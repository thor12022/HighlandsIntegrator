package thor12022.highlandsintegrator;

/*
 * Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
 * If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.
 */

//import biomesoplenty.api.content.BOPCBiomes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import thor12022.highlandsintegrator.modhandlers.BuildCraftHandler;
import thor12022.highlandsintegrator.modhandlers.ThaumcraftHandler;
import thor12022.highlandsintegrator.proxies.CommonProxy;
import thor12022.highlandsintegrator.util.EventHandler;
import thor12022.highlandsintegrator.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import scala.Array;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class HighlandsIntegrator
{

   @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
   public static CommonProxy proxy;

   public static Logger logger = LogManager.getLogger(ModInformation.NAME);

   @Mod.Instance
   public static HighlandsIntegrator instance;

   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));

      ConfigHandler.init(event.getSuggestedConfigurationFile());

      FMLCommonHandler.instance().bus().register(new EventHandler());
   }

   @Mod.EventHandler
   public void init(FMLInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init"));

      if( Loader.isModLoaded("Thaumcraft") )
      {
    	  ThaumcraftHandler.init(event);
      }
      if( Loader.isModLoaded("BuildCraft|Energy"))
      {
    	  BuildCraftHandler.init(event);
      }
   }

   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.postInit"));
   }

   @Mod.EventHandler
   public void onFMLServerStartedEvent(FMLServerStartedEvent event)
   {
   }
}
