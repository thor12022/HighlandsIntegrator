package main.escapeintegration.items;

/*
 * Base item class for getting standard things done with quickly.
 * Extend this for pretty much every item you make.
 */

import main.escapeintegration.EscapeIntegration;
import main.escapeintegration.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	// If you aren't setting multiple textures for your item. IE: Non-Metadata items.
	public ItemBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(EscapeIntegration.tabBaseMod);
	}

	// If you are setting multiple textures for your item. IE: Metadata items.
	public ItemBase(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setCreativeTab(EscapeIntegration.tabBaseMod);
	}
}
