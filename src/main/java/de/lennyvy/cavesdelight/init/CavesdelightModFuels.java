/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class CavesdelightModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == CavesdelightModItems.DEEP_COAL.get())
			event.setBurnTime(16000);
	}
}