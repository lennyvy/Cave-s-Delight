package de.lennyvy.cavesdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedAxolotlHamItem extends Item {
	public CookedAxolotlHamItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(11).saturationModifier(1.5f).build()));
	}
}