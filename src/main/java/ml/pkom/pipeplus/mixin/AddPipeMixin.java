package ml.pkom.pipeplus.mixin;

import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.client.model.PipeBaseModelGenStandard;
import alexiil.mc.mod.pipes.client.model.SpriteSupplier;
import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import ml.pkom.pipeplus.blocks.RedStonePipe;
import ml.pkom.pipeplus.parts.PipePlusParts;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(PipeBaseModelGenStandard.class)
public class AddPipeMixin {
	@Inject(method = "getCenterSprite", at = @At("TAIL"), cancellable = true, remap = false)
	private static void getCenterSprite(SpriteSupplier sprites, PipeSpDef def, CallbackInfoReturnable<Sprite> cir) {
		if (def == PipePlusParts.OBSIDIAN_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/obsidian_pipe"));
		if (def == PipePlusParts.ENDER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/ender_pipe"));
		if (def == PipePlusParts.COPPER_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_pipe"));
		if (def == PipePlusParts.TIN_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_pipe"));
		if (def == PipePlusParts.SILVER_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_pipe"));
		if (def == PipePlusParts.STACK_EXTRACT_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/stack_extract_pipe"));
		if (def == PipePlusParts.COPPER_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_fluid_pipe"));
		if (def == PipePlusParts.TIN_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_fluid_pipe"));
		if (def == PipePlusParts.SILVER_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_fluid_pipe"));
		if (def == PipePlusParts.EMERALD_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/emerald_pipe"));
		if (def == PipePlusParts.RUBY_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/ruby_pipe"));
		if (def == PipePlusParts.REDSTONE_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite(((RedStonePipe) def.pipeBlock).isPowered() ? "pipeplus:block/active_redstone_pipe" : "pipeplus:block/redstone_pipe"));
		if (def == PipePlusParts.TELEPORT_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/pipe_items_teleport"));
		if (def == PipePlusParts.COBBLESTONE_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/cobblestone_pipe"));
		if (def == PipePlusParts.VOID_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/void_item"));
	}

	@Inject(method = "getSprite", at = @At("TAIL"), cancellable = true, remap = false)
	private static void getSprite(SpriteSupplier sprites, TilePipe.PipeBlockModelState key, Direction face, CallbackInfoReturnable<Sprite> cir) {
		if (key.def == PipePlusParts.COPPER_ITEM_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_pipe_filled"));
			}
		}
		if (key.def == PipePlusParts.TIN_ITEM_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_pipe_filled"));
			}
		}
		if (key.def == PipePlusParts.SILVER_ITEM_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_pipe_filled"));
			}
		}
		if (key.def == PipePlusParts.STACK_EXTRACT_ITEM_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/stack_extract_pipe_filled"));
			}
		}
		if (key.def == PipePlusParts.COPPER_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_fluid_pipe_filled"));
			}
		}
		if (key.def == PipePlusParts.TIN_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_fluid_pipe_filled"));
			}
		}
		if (key.def == PipePlusParts.SILVER_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_fluid_pipe_filled"));
			}
		}
	}
}