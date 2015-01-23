package main.feedthecreepertweaks;

/*
 * Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
 * If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.
 */

//import biomesoplenty.api.content.BOPCBiomes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import main.feedthecreepertweaks.blocks.BlockRecipeRegistry;
import main.feedthecreepertweaks.blocks.BlockRegistry;
import main.feedthecreepertweaks.client.gui.CreativeTabBaseMod;
import main.feedthecreepertweaks.client.gui.GuiHandler;
import main.feedthecreepertweaks.items.ItemRecipeRegistry;
import main.feedthecreepertweaks.items.ItemRegistry;
import main.feedthecreepertweaks.modhandlers.ThaumcraftHandler;
import main.feedthecreepertweaks.modhandlers.BiomesOPlentyHandler;
import main.feedthecreepertweaks.proxies.CommonProxy;
import main.feedthecreepertweaks.util.EventHandler;
import main.feedthecreepertweaks.util.OreDictHandler;
import main.feedthecreepertweaks.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import scala.Array;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class FeedTheCreeperTweaks
{

   @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
   public static CommonProxy proxy;

   public static CreativeTabs tabBaseMod = new CreativeTabBaseMod(ModInformation.ID + ".creativeTab");
   public static Logger logger = LogManager.getLogger(ModInformation.NAME);

   @Mod.Instance
   public static FeedTheCreeperTweaks instance;

   private static BiomeGenBase[] vanillaOverworldBiomes = new BiomeGenBase[] { BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.forestHills, BiomeGenBase.taigaHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.jungleEdge, BiomeGenBase.stoneBeach, BiomeGenBase.coldBeach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.extremeHillsPlus, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F };
   
   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));

      ConfigHandler.init(event.getSuggestedConfigurationFile());

      ItemRegistry.registerItems();
      BlockRegistry.registerBlocks();

      OreDictHandler.registerOreDict();
      FMLCommonHandler.instance().bus().register(new EventHandler());
      NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());   
   }
   
   @Mod.EventHandler
   public void init(FMLInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init"));

      ItemRecipeRegistry.registerItemRecipes();
      BlockRecipeRegistry.registerBlockRecipes();
      
      ThaumcraftHandler.init(event);
      BiomesOPlentyHandler.init(event);
   }

   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.postInit"));
      EntityHelper.init();
      if( ConfigHandler.doDebug )
      { 
         EntityHelper.debugInformation();
      } 
      EntityHelper.adjustEntities();
      if( ConfigHandler.doDebug )
      { 
         EntityHelper.debugInformation();
      }
   }
}
