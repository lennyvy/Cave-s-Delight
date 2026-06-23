package de.lennyvy.cavesdelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedAxolotlHamItem extends Item {
	public CookedAxolotlHamItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.8f).build()));
	}
}