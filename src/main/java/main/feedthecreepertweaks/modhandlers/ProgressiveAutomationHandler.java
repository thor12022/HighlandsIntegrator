package main.feedthecreepertweaks.modhandlers;

import java.util.ArrayList;
import java.util.List;

import com.vanhal.progressiveautomation.items.tools.RecipeWitherTool;
import com.vanhal.progressiveautomation.items.tools.WitherTools;

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
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ProgressiveAutomationHandler
{
   public static Item witheredWoodAxe;
   public static Item witheredWoodHoe;
   public static Item witheredWoodPick;
   public static Item witheredWoodShovel;
   public static Item witheredWoodSword;
   public static Item witheredStoneAxe;
   public static Item witheredStoneHoe;
   public static Item witheredStonePick;
   public static Item witheredStoneShovel;
   public static Item witheredStoneSword;
   public static Item witheredIronAxe;
   public static Item witheredIronHoe;
   public static Item witheredIronPick;
   public static Item witheredIronShovel;
   public static Item witheredIronSword;
   public static Item witheredDiamondAxe;
   public static Item witheredDiamondHoe;
   public static Item witheredDiamondPick;
   public static Item witheredDiamondShovel;
   public static Item witheredDiamondSword;
   
   public static void preinit(FMLPreInitializationEvent event)
   {
      if(ConfigHandler.progressiveAutomationToolOverride)
      {
         RegisterNewWitheredItems();
      }
   }
   
   public static void init(FMLInitializationEvent event)
   {
      if(ConfigHandler.progressiveAutomationToolOverride)
      {
         RemoveWitheredRecipes();
         RegisterNewWitheredRecipes();
      }
   }
   
   private static void RegisterNewWitheredItems()
   {
      witheredWoodAxe = new ItemUnbreakingAxe( Item.ToolMaterial.WOOD, "axeWitheredWood", "wood_axe" );
      GameRegistry.registerItem(witheredWoodAxe, "axeWitheredWood");
      
      witheredWoodHoe = new ItemUnbreakingHoe( Item.ToolMaterial.WOOD, "hoeWitheredWood", "wood_hoe" );
      GameRegistry.registerItem(witheredWoodHoe, "hoeWitheredWood");
      
      witheredWoodPick = new ItemUnbreakingPick( Item.ToolMaterial.WOOD, "pickWitheredWood", "wood_pickaxe" );
      GameRegistry.registerItem(witheredWoodPick, "pickWitheredWood");
      
      witheredWoodShovel = new ItemUnbreakingShovel( Item.ToolMaterial.WOOD, "shovelWitheredWood", "wood_shovel" );
      GameRegistry.registerItem(witheredWoodShovel, "shovelWitheredWood");
      
      witheredWoodSword = new ItemUnbreakingSword( Item.ToolMaterial.WOOD, "swordWitheredWood", "wood_sword" );
      GameRegistry.registerItem(witheredWoodSword, "swordWitheredWood");
     
      witheredStoneAxe = new ItemUnbreakingAxe( Item.ToolMaterial.STONE, "axeWitheredStone", "stone_axe" );
      GameRegistry.registerItem(witheredStoneAxe, "axeWitheredStone");
      
      witheredStoneHoe = new ItemUnbreakingHoe( Item.ToolMaterial.STONE, "hoeWitheredStone", "stone_hoe" );
      GameRegistry.registerItem(witheredStoneHoe, "hoeWitheredStone");
      
      witheredStonePick = new ItemUnbreakingPick( Item.ToolMaterial.STONE, "pickWitheredStone", "stone_pickaxe" );
      GameRegistry.registerItem(witheredStonePick, "pickWitheredStone");
      
      witheredStoneShovel = new ItemUnbreakingShovel( Item.ToolMaterial.STONE, "shovelWitheredStone", "stone_shovel" );
      GameRegistry.registerItem(witheredStoneShovel, "shovelWitheredStone");
      
      witheredStoneSword = new ItemUnbreakingSword( Item.ToolMaterial.STONE, "swordWitheredStone", "stone_sword" );
      GameRegistry.registerItem(witheredStoneSword, "swordWitheredStone");
      
      witheredIronAxe = new ItemUnbreakingAxe( Item.ToolMaterial.IRON, "axeWitheredIron", "iron_axe" );
      GameRegistry.registerItem(witheredIronAxe, "axeWitheredIron");
      
      witheredIronHoe = new ItemUnbreakingHoe( Item.ToolMaterial.IRON, "hoeWitheredIron", "iron_hoe" );
      GameRegistry.registerItem(witheredIronHoe, "hoeWitheredIron");
      
      witheredIronPick = new ItemUnbreakingPick( Item.ToolMaterial.IRON, "pickWitheredIron", "iron_pickaxe" );
      GameRegistry.registerItem(witheredIronPick, "pickWitheredIron");
      
      witheredIronShovel = new ItemUnbreakingShovel( Item.ToolMaterial.IRON, "shovelWitheredIron", "iron_shovel" );
      GameRegistry.registerItem(witheredIronShovel, "shovelWitheredIron");
      
      witheredIronSword = new ItemUnbreakingSword( Item.ToolMaterial.IRON, "swordWitheredIron", "iron_sword" );
      GameRegistry.registerItem(witheredIronSword, "swordWitheredIron");
      
      witheredDiamondAxe = new ItemUnbreakingAxe( Item.ToolMaterial.EMERALD, "axeWitheredDiamond", "diamond_axe" );
      GameRegistry.registerItem(witheredDiamondAxe, "axeWitheredDiamond");
      
      witheredDiamondHoe = new ItemUnbreakingHoe( Item.ToolMaterial.EMERALD, "hoeWitheredDiamond", "diamond_hoe" );
      GameRegistry.registerItem(witheredDiamondHoe, "hoeWitheredDiamond");
      
      witheredDiamondPick = new ItemUnbreakingPick( Item.ToolMaterial.EMERALD, "pickWitheredDiamond", "diamond_pickaxe" );
      GameRegistry.registerItem(witheredDiamondPick, "pickWitheredDiamond");
      
      witheredDiamondShovel = new ItemUnbreakingShovel( Item.ToolMaterial.EMERALD, "shovelWitheredDiamond", "diamond_shovel" );
      GameRegistry.registerItem(witheredDiamondShovel, "shovelWitheredDiamond");
      
      witheredDiamondSword = new ItemUnbreakingSword( Item.ToolMaterial.EMERALD, "swordWitheredDiamond", "diamond_sword" );
      GameRegistry.registerItem(witheredDiamondSword, "swordWitheredDiamond");
   }
   
   private static void RegisterNewWitheredRecipes()
   {
      FeedTheCreeperTweaks.logger.debug("Adding Replacement Progressive Automation Withered Tool Recipes");
      
      RecipeWitherTool recipe = new RecipeWitherTool(witheredWoodAxe, new Object[]{
            "mm ", "ms ", " s ", 'm', WitherTools.witherWood, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredWoodHoe, new Object[]{
            "mm ", " s ", " s ", 'm', WitherTools.witherWood, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredWoodPick, new Object[]{
            "mmm", " s ", " s ", 'm', WitherTools.witherWood, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredWoodShovel, new Object[]{
            " m ", " s ", " s ", 'm', WitherTools.witherWood, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredWoodSword, new Object[]{
            " m ", " m ", " s ", 'm', WitherTools.witherWood, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      
      recipe = new RecipeWitherTool(witheredStoneAxe, new Object[]{
            "mm ", "ms ", " s ", 'm', WitherTools.witherStone, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredStoneHoe, new Object[]{
            "mm ", " s ", " s ", 'm', WitherTools.witherStone, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredStonePick, new Object[]{
            "mmm", " s ", " s ", 'm', WitherTools.witherStone, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredStoneShovel, new Object[]{
            " m ", " s ", " s ", 'm', WitherTools.witherStone, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredStoneSword, new Object[]{
            " m ", " m ", " s ", 'm', WitherTools.witherStone, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      
      recipe = new RecipeWitherTool(witheredIronAxe, new Object[]{
            "mm ", "ms ", " s ", 'm', WitherTools.witherIron, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredIronHoe, new Object[]{
            "mm ", " s ", " s ", 'm', WitherTools.witherIron, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredIronPick, new Object[]{
            "mmm", " s ", " s ", 'm', WitherTools.witherIron, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredIronShovel, new Object[]{
            " m ", " s ", " s ", 'm', WitherTools.witherIron, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredIronSword, new Object[]{
            " m ", " m ", " s ", 'm', WitherTools.witherIron, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      
      recipe = new RecipeWitherTool(witheredDiamondAxe, new Object[]{
            "mm ", "ms ", " s ", 'm', WitherTools.witherDiamond, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredDiamondHoe, new Object[]{
            "mm ", " s ", " s ", 'm', WitherTools.witherDiamond, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredDiamondPick, new Object[]{
            "mmm", " s ", " s ", 'm', WitherTools.witherDiamond, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredDiamondShovel, new Object[]{
            " m ", " s ", " s ", 'm', WitherTools.witherDiamond, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
      recipe = new RecipeWitherTool(witheredDiamondSword, new Object[]{
            " m ", " m ", " s ", 'm', WitherTools.witherDiamond, 's', Items.stick});
      GameRegistry.addRecipe(recipe);
   }
   
   private static void RemoveWitheredRecipes()
   {
      List progressiveAutomationRecipes = new ArrayList();
      for (Object recipe : CraftingManager.getInstance().getRecipeList())
      {
         if(recipe instanceof RecipeWitherTool)
         {
            progressiveAutomationRecipes.add(recipe);
         }
      }
      FeedTheCreeperTweaks.logger.debug("Removing Progressive Automation Withered Tool recipes");
      for (Object recipe : progressiveAutomationRecipes)
      {
         CraftingManager.getInstance().getRecipeList().remove(recipe);
      }
   }
}
