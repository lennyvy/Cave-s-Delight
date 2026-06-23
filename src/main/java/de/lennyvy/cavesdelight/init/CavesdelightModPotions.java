/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import de.lennyvy.cavesdelight.CavesdelightMod;

public class CavesdelightModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, CavesdelightMod.MODID);
	public static final DeferredHolder<Potion, Potion> ECHO_SIGHT_POTION = REGISTRY.register("echo_sight_potion", () -> new Potion(new MobEffectInstance(CavesdelightModMobEffects.ECHO_SIGHT, 3600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> ECHO_SIGHT_2 = REGISTRY.register("echo_sight_2", () -> new Potion(new MobEffectInstance(CavesdelightModMobEffects.ECHO_SIGHT, 9600, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> ECHO_SIGHT_3 = REGISTRY.register("echo_sight_3", () -> new Potion(new MobEffectInstance(CavesdelightModMobEffects.ECHO_SIGHT, 6000, 1, false, true)));
}