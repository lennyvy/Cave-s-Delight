/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import de.lennyvy.cavesdelight.client.model.ModelDeepCoalGolem;

@EventBusSubscriber(Dist.CLIENT)
public class CavesdelightModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelDeepCoalGolem.LAYER_LOCATION, ModelDeepCoalGolem::createBodyLayer);
	}
}