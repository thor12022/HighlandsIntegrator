package main.feedthecreepertweaks.items;

/*
 * Base item class for getting standard things done with quickly.
 * Extend this for pretty much every item you make.
 */

import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import main.feedthecreepertweaks.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item
{

   // If you aren't setting multiple textures for your item. IE: Non-Metadata
   // items.
   public ItemBase(String unlocName, String textureName)
   {
      super();

      setUnlocalizedName(ModInformation.ID + "." + unlocName);
      setTextureName(ModInformation.ID + ":" + textureName);
      setCreativeTab(FeedTheCreeperTweaks.tabBaseMod);
   }

   // If you are setting multiple textures for your item. IE: Metadata items.
   public ItemBase(String unlocName)
   {
      super();

      setUnlocalizedName(ModInformation.ID + "." + unlocName);
      setCreativeTab(FeedTheCreeperTweaks.tabBaseMod);
   }
}
