package de.lennyvy.cavesdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class RawAxolotlSliceItem extends Item {
	public RawAxolotlSliceItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.5f).build()));
	}
}