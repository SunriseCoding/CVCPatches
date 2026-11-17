package io.github.sunrisecoding.cvcpatches.mixins.industrialfan;

import dev.lopyluna.dndesires.content.blocks.kinetics.industrial_fan.IndustrialFanRenderer;
import dev.lopyluna.dndesires.register.client.DesiresPartialModels;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IndustrialFanRenderer.class)
public class IndustrialFanClientFix {
    @Inject(
            at = @At("HEAD"),
            method = "renderSafe*",
            cancellable = true
    )
    private void industrialFanRenderer(CallbackInfo ci) {
        if (DesiresPartialModels.INDUSTRIAL_FAN_POWER == null || DesiresPartialModels.INDUSTRIAL_FAN_INNER == null) {
            ci.cancel();
        }
    }
}
