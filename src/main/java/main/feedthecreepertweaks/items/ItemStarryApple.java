package main.feedthecreepertweaks.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.feedthecreepertweaks.ConfigHandler;
import main.feedthecreepertweaks.FeedTheCreeperTweaks;
import main.feedthecreepertweaks.ModInformation;
import main.feedthecreepertweaks.potions.PotionAntiWither;
import main.feedthecreepertweaks.potions.PotionRegistry;
import main.feedthecreepertweaks.util.TextHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemStarryApple extends ItemFood
{
   public ItemStarryApple()
   {
      super(4, 1.2F, false);
      setUnlocalizedName(ModInformation.ID + ".starryApple");
      setTextureName(ModInformation.ID + ":starryApple");
      setCreativeTab(FeedTheCreeperTweaks.tabBaseMod);
      this.setAlwaysEdible();
   }
   
   @SideOnly(Side.CLIENT)
   public boolean hasEffect(ItemStack stack)
   {
       return true;
   }
   
   @Override
   @SideOnly(Side.CLIENT)
   public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
   {
      list.add(TextHelper.GREEN + TextHelper.ITALIC + TextHelper.localize("tooltip." + ModInformation.ID + ".starryApple"));
   }
   
   @Override
   public EnumRarity getRarity(ItemStack stack)
   {
       return EnumRarity.epic;
   }

   @Override
   public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
   {
       if (!world.isRemote)
       {
          player.addPotionEffect(new PotionEffect(PotionRegistry.potionAntiWither.id, 2400, 0));
          player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id,          1200, 0));
          player.addPotionEffect(new PotionEffect(Potion.regeneration.id,           900, 1));
          player.addPotionEffect(new PotionEffect(Potion.resistance.id,             900, 1));
          player.addPotionEffect(new PotionEffect(Potion.damageBoost.id,            900, 1));
          player.addPotionEffect(new PotionEffect(Potion.heal.id,                   0,    0));
       }
   }
}
