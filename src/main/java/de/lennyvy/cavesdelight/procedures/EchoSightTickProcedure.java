package de.lennyvy.cavesdelight.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.List;

import de.lennyvy.cavesdelight.init.CavesdelightModMobEffects;

@EventBusSubscriber
public class EchoSightTickProcedure {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        execute(event.getEntity().level(), event.getEntity(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
    }

    public static void execute(LevelAccessor world, Entity entity, double x, double y, double z) {
        if (!(entity instanceof LivingEntity player))
            return;

        if (!player.hasEffect(CavesdelightModMobEffects.ECHO_SIGHT))
            return;

        double timer = player.getPersistentData().getDouble("echo_timer");
        int cycle = player.getPersistentData().getInt("echo_cycle");

        if (timer == 0) {
            timer = 20;
            player.getPersistentData().putDouble("echo_timer", timer);
            player.getPersistentData().putInt("echo_cycle", 0);
            return;
        }
        timer = timer - 1;
        player.getPersistentData().putDouble("echo_timer", timer);
        
        if (timer <= 0) {
        	
            cycle++;
            player.getPersistentData().putInt("echo_cycle", cycle);
            
            if (cycle % 3 == 0) {
                player.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.heartbeat")));
            }
            player.getPersistentData().putDouble("echo_timer", 20);
            int amplifier = player.getEffect(CavesdelightModMobEffects.ECHO_SIGHT).getAmplifier();
            double cubeSize = (1 + amplifier) * 16;
            if (cubeSize > 64) cubeSize = 64;

            AABB scanArea = new AABB(x - cubeSize/2, y - cubeSize/2, z - cubeSize/2,
                                     x + cubeSize/2, y + cubeSize/2, z + cubeSize/2);
            List<Entity> entities = world.getEntitiesOfClass(Entity.class, scanArea, e -> true);

            for (Entity target : entities) {
                if (target == player) continue;
                if (!(target instanceof LivingEntity livingTarget)) continue;
                Vec3 velocity = target.getDeltaMovement();
                if (velocity.x == 0 && velocity.y == 0 && velocity.z == 0) continue;
                livingTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, false, false));
            }
        }
    }
}