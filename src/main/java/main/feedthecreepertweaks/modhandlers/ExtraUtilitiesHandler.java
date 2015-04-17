package main.feedthecreepertweaks.modhandlers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.rwtema.extrautils.ExtraUtils;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import main.feedthecreepertweaks.items.ItemUnbreakingAxe;
import main.feedthecreepertweaks.items.ItemUnbreakingHoe;
import main.feedthecreepertweaks.items.ItemUnbreakingPick;
import main.feedthecreepertweaks.items.ItemUnbreakingShovel;
import main.feedthecreepertweaks.items.ItemUnbreakingSword;

public class ExtraUtilitiesHandler
{
   public static Item bedrockiumAxe;
   public static Item bedrockiumHoe;
   public static Item bedrockiumPick;
   public static Item bedrockiumShovel;
   public static Item bedrockiumSword;
   
   static private ToolMaterial materialBedrockium = EnumHelper.addToolMaterial("bedrockium", 6, 0, 8.0F, 4.0F, 20);
   
   public static void preinit(FMLPreInitializationEvent event)
   {
      if(ConfigHandler.unbreakableEtherealTools)
      { 
         FeedTheCreeperTweaks.logger.info("Making Ethereal Tools Unbreakable");
      
         ExtraUtils.healingAxe.setMaxDamage(0);
         ExtraUtils.temporalHoe.setMaxDamage(0);
         ExtraUtils.ethericSword.setMaxDamage(0);
         ExtraUtils.erosionShovel.setMaxDamage(0);
         ExtraUtils.destructionPickaxe.setMaxDamage(0);
      }
      
      if(ConfigHandler.enableBedrockiumTools)
      {   
         FeedTheCreeperTweaks.logger.info("Registering Bedrockium Tools");
         bedrockiumAxe = new ItemUnbreakingAxe( materialBedrockium, "axeBedrockium", ModInformation.ID + ":" + "axeBedrockium" );
         GameRegistry.registerItem(bedrockiumAxe, "axeBedrockium");
         
         bedrockiumHoe = new ItemUnbreakingHoe( materialBedrockium, "hoeBedrockium", ModInformation.ID + ":" + "hoeBedrockium" );
         GameRegistry.registerItem(bedrockiumHoe, "hoeBedrockium");
         
         bedrockiumPick = new ItemUnbreakingPick( materialBedrockium, "pickBedrockium", ModInformation.ID + ":" + "pickaxeBedrockium" );
         GameRegistry.registerItem(bedrockiumPick, "pickBedrockium");
         
         bedrockiumShovel = new ItemUnbreakingShovel( materialBedrockium, "shovelBedrockium", ModInformation.ID + ":" + "shovelBedrockium" );
         GameRegistry.registerItem(bedrockiumShovel, "shovelBedrockium");
         
         bedrockiumSword = new ItemUnbreakingSword( materialBedrockium, "swordBedrockium", ModInformation.ID + ":" + "swordBedrockium" );
         GameRegistry.registerItem(bedrockiumSword, "swordBedrockium");
      }
   }
   
   public static void init(FMLInitializationEvent event)
   {
      if(ConfigHandler.enableBedrockiumTools)
      { 
         FeedTheCreeperTweaks.logger.info("Creating Recipes for Bedrockium Tools");
         
         GameRegistry.addShapedRecipe(new ItemStack(bedrockiumAxe), new Object[]{
            "mm ", 
            "ms ", 
            " s ", 
            'm', ExtraUtils.bedrockium, 
            's', Item.getItemFromBlock(Blocks.obsidian)});
      
         GameRegistry.addShapedRecipe(new ItemStack(bedrockiumHoe), new Object[]{
            "mm ", 
            " s ", 
            " s ", 
            'm', ExtraUtils.bedrockium, 
            's', Item.getItemFromBlock(Blocks.obsidian)});
         
         GameRegistry.addShapedRecipe(new ItemStack(bedrockiumPick), new Object[]{
            "mmm", 
            " s ", 
            " s ", 
            'm', ExtraUtils.bedrockium, 
            's', Item.getItemFromBlock(Blocks.obsidian)});
         
         GameRegistry.addShapedRecipe(new ItemStack(bedrockiumShovel), new Object[]{
            " m ", 
            " s ", 
            " s ", 
            'm', ExtraUtils.bedrockium, 
            's', Item.getItemFromBlock(Blocks.obsidian)});
         
         GameRegistry.addShapedRecipe(new ItemStack(bedrockiumSword), new Object[]{
            " m ", 
            " m ", 
            " s ", 
            'm', ExtraUtils.bedrockium, 
            's', Item.getItemFromBlock(Blocks.obsidian)});
      }
   }
}
