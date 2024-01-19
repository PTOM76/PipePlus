package ml.pkom.pipeplus.mixin;

import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import alexiil.mc.mod.pipes.pipe.TravellingItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PipeSpFlowItem.class)
public class PipeSpFlowItemMixin {
    @Inject(method = "onItemReachCenter", at = @At(value = "INVOKE", target = "Lalexiil/mc/mod/pipes/pipe/PipeSpFlowItem;dropItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/math/Direction;Lnet/minecraft/util/math/Direction;D)V", ordinal = 0), cancellable = true)
    private void onItemReachCenter(TravellingItem item, CallbackInfo ci) {
        if(item.stack.getSubNbt("pipeplus-teleporting") != null) {
            ci.cancel();
        }
    }
}
