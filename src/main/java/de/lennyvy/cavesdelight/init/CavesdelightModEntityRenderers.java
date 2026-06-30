/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import de.lennyvy.cavesdelight.client.renderer.DeepCoalGolemRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class CavesdelightModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CavesdelightModEntities.DEEP_COAL_GOLEM.get(), DeepCoalGolemRenderer::new);
	}
}