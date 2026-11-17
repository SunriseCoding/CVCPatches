package io.github.sunrisecoding.cvcpatches.mixins.boreheadbearing;

import dev.ryanhcode.sable.util.LevelAccelerator;
import org.spongepowered.asm.mixin.Mixin;

import dev.ryanhcode.offroad.content.blocks.borehead_bearing.BoreheadBearingBlockEntity;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BoreheadBearingBlockEntity.class)
public class BoreheadBearingFix {

    @Shadow
    private LevelAccelerator accelerator;

    @Inject(
            method = "updateMiningBlocks",
            at = @At("HEAD"),
            cancellable = true
    )
    private void preventNullAccelerator(CallbackInfo ci) {
        BoreheadBearingBlockEntity self =
                (BoreheadBearingBlockEntity) (Object) this;

        if (this.accelerator == null) {
            ci.cancel();
        }
    }
}
