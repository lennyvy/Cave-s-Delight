package de.lennyvy.cavesdelight.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class EchoSightEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = entity;
		if (player instanceof Player) {
			player.getPersistentData().putDouble("echo_timer", 20);
		}
	}
}