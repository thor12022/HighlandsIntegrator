package main.feedthecreepertweaks.items;

/*
 * General place to do all your item related recipe things'n'stuff.
 */

import java.util.ArrayList;
import java.util.List;

import com.vanhal.progressiveautomation.items.tools.RecipeWitherTool;
import com.vanhal.progressiveautomation.items.tools.WitherTools;

import cpw.mods.fml.common.registry.GameRegistry;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import main.feedthecreepertweaks.blocks.BlockRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry
{
   // Self explanatory. Continue these how you wish. EG: registerSmeltingRecipes
   private static void registerShapedRecipes()
   {
      // GameRegistry.addRecipe(new ShapedOreRecipe(new
      // ItemStack(Items.blaze_rod), new Object[]{"X  ", " X ", "  X", 'X',
      // "powderBlaze"}));  
     
      if(ConfigHandler.enableStarryApple)
      {
         GameRegistry.addShapedRecipe(new ItemStack(ItemRegistry.starryApple), new Object[]{
            " s ", 
            "sas", 
            " s ", 
            'a', Items.apple, 
            's', Items.nether_star});
      }
      
   }

   private static void registerShaplessRecipes()
   {
      // GameRegistry.addShapelessRecipe(new
      // ItemStack(BlockRegistry.exampleBlock), new
      // ItemStack(ItemRegistry.exampleItem, 9));
   }

   public static void registerItemRecipes()
   {
      registerShapedRecipes();
      registerShaplessRecipes();
   }
}
