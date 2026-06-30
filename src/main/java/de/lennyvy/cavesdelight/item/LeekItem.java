package de.lennyvy.cavesdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class LeekItem extends Item {
	public LeekItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.75f).build()));
	}
}