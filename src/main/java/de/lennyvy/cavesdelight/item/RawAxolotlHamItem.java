package de.lennyvy.cavesdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class RawAxolotlHamItem extends Item {
	public RawAxolotlHamItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationModifier(0.3f).build()));
	}
}