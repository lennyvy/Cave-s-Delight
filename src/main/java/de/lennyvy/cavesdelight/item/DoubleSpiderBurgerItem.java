package de.lennyvy.cavesdelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class DoubleSpiderBurgerItem extends Item {
	public DoubleSpiderBurgerItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(17).saturationModifier(0.9f).build()));
	}
}