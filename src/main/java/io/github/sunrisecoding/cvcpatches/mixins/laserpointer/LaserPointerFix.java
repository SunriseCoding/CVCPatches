package io.github.sunrisecoding.cvcpatches.mixins.laserpointer;

import dev.simulated_team.simulated.content.blocks.lasers.laser_sensor.LaserSensorInteractorBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "dev.simulated_team.simulated.content.blocks.lasers.laser_pointer.LaserPointerBlockEntity")
public class LaserPointerFix {

    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Ldev/simulated_team/simulated/content/blocks/lasers/laser_sensor/LaserSensorInteractorBehaviour;getBlockHitResult()Lnet/minecraft/world/phys/BlockHitResult;"
            )
    )
    private BlockHitResult preventNullContext(
            LaserSensorInteractorBehaviour instance
    ) {
        BlockHitResult result = instance.getBlockHitResult();

        return result != null
                ? result
                : BlockHitResult.miss(
                Vec3.ZERO,
                net.minecraft.core.Direction.UP,
                net.minecraft.core.BlockPos.ZERO
        );
    }
}