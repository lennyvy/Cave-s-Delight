/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package de.lennyvy.cavesdelight.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import de.lennyvy.cavesdelight.potion.EchoSightMobEffect;
import de.lennyvy.cavesdelight.CavesdelightMod;

public class CavesdelightModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, CavesdelightMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ECHO_SIGHT = REGISTRY.register("echo_sight", () -> new EchoSightMobEffect());
}