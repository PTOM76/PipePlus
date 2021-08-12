package ml.pkom.pipeplus.mixin;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.SimplePipeBlocks;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.client.model.PipeBaseModelGenStandard;
import alexiil.mc.mod.pipes.client.model.SpriteSupplier;
import ml.pkom.pipeplus.blocks.Blocks;
import ml.pkom.pipeplus.blocks.RedStonePipe;
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
	private static void getCenterSprite(SpriteSupplier sprites, BlockPipe block, CallbackInfoReturnable<Sprite> cir) {
		if (block == Blocks.OBSIDIAN_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/obsidian_pipe"));
		if (block == Blocks.ENDER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/ender_pipe"));
		if (block == Blocks.COPPER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/copper_pipe"));
		if (block == Blocks.TIN_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/tin_pipe"));
		if (block == Blocks.SILVER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/silver_pipe"));
		if (block == Blocks.COPPER_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/copper_fluid_pipe"));
		if (block == Blocks.TIN_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/tin_fluid_pipe"));
		if (block == Blocks.SILVER_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/silver_fluid_pipe"));
		if (block == Blocks.EMERALD_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/emerald_pipe"));
		if (block == Blocks.RUBY_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/ruby_pipe"));
		if (block == Blocks.REDSTONE_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/redstone_pipe"));
		if (block == Blocks.PIPE_ITEMS_TELEPORT)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/pipe_items_teleport"));
		if (block == Blocks.COBBLESTONE_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/cobblestone_pipe"));
	}

	@Inject(method = "getSprite", at = @At("TAIL"), cancellable = true, remap = false)
	private static void getSprite(SpriteSupplier sprites, TilePipe.PipeBlockModelState key, Direction face, CallbackInfoReturnable<Sprite> cir) {
		if (key.block == Blocks.COPPER_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/copper_pipe_filled"));
			}
		}
		if (key.block == Blocks.TIN_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/tin_pipe_filled"));
			}
		}
		if (key.block == Blocks.SILVER_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/silver_pipe_filled"));
			}
		}
		if (key.block == Blocks.COPPER_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/copper_fluid_pipe_filled"));
			}
		}
		if (key.block == Blocks.TIN_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/tin_fluid_pipe_filled"));
			}
		}
		if (key.block == Blocks.SILVER_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/silver_fluid_pipe_filled"));
			}
		}
		if (key.block == Blocks.REDSTONE_PIPE) {
			if (((RedStonePipe) key.block).isPowered()) {
				cir.setReturnValue(sprites.getBlockSprite("pipeplus:pipes/active_redstone_pipe"));
			}
		}
	}
}