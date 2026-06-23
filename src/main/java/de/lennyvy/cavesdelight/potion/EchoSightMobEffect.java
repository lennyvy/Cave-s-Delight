package de.lennyvy.cavesdelight.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import de.lennyvy.cavesdelight.procedures.EchoSightEffectStartedappliedProcedure;

public class EchoSightMobEffect extends MobEffect {
	public EchoSightMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10092340);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.heartbeat")));
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		EchoSightEffectStartedappliedProcedure.execute(entity);
	}
}