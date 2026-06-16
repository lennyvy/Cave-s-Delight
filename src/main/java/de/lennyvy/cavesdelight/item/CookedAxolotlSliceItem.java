package de.lennyvy.cavesdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedAxolotlSliceItem extends Item {
	public CookedAxolotlSliceItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(7).saturationModifier(1.2f).build()));
	}
}