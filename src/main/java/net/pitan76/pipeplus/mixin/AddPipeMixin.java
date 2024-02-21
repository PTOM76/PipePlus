package net.pitan76.pipeplus.mixin;

import alexiil.mc.mod.pipes.blocks.BlockPipe;
import alexiil.mc.mod.pipes.blocks.TilePipe;
import alexiil.mc.mod.pipes.blocks.TilePipeSided;
import alexiil.mc.mod.pipes.client.model.PipeBaseModelGenStandard;
import alexiil.mc.mod.pipes.client.model.SpriteSupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.Direction;
import net.pitan76.pipeplus.blocks.Blocks;
import net.pitan76.pipeplus.blocks.RedStonePipe;
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
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/obsidian_pipe"));
		if (block == Blocks.ENDER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/ender_pipe"));
		if (block == Blocks.COPPER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_pipe"));
		if (block == Blocks.TIN_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_pipe"));
		if (block == Blocks.SILVER_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_pipe"));
		if (block == Blocks.STACK_EXTRACT_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/stack_extract_pipe"));
		if (block == Blocks.COPPER_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_fluid_pipe"));
		if (block == Blocks.TIN_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_fluid_pipe"));
		if (block == Blocks.SILVER_FLUID_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_fluid_pipe"));
		if (block == Blocks.EMERALD_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/emerald_pipe"));
		if (block == Blocks.RUBY_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/ruby_pipe"));
		if (block == Blocks.REDSTONE_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/redstone_pipe"));
		if (block == Blocks.PIPE_ITEMS_TELEPORT)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/pipe_items_teleport"));
		if (block == Blocks.COBBLESTONE_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/cobblestone_pipe"));
		if (block == Blocks.VOID_ITEM_PIPE)
			cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/void_item"));
	}

	@Inject(method = "getSprite", at = @At("TAIL"), cancellable = true, remap = false)
	private static void getSprite(SpriteSupplier sprites, TilePipe.PipeBlockModelState key, Direction face, CallbackInfoReturnable<Sprite> cir) {
		if (key.block == Blocks.COPPER_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_pipe_filled"));
			}
		}
		if (key.block == Blocks.TIN_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_pipe_filled"));
			}
		}
		if (key.block == Blocks.SILVER_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_pipe_filled"));
			}
		}
		if (key.block == Blocks.STACK_EXTRACT_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/stack_extract_pipe_filled"));
			}
		}
		if (key.block == Blocks.COPPER_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/copper_fluid_pipe_filled"));
			}
		}
		if (key.block == Blocks.TIN_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/tin_fluid_pipe_filled"));
			}
		}
		if (key.block == Blocks.SILVER_FLUID_PIPE) {
			if (key instanceof TilePipeSided.PipeBlockModelStateSided) {
				Direction mainDir = ((TilePipeSided.PipeBlockModelStateSided)key).mainSide;
				if (mainDir == face) cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/silver_fluid_pipe_filled"));
			}
		}
		if (key.block == Blocks.REDSTONE_PIPE) {
			if (((RedStonePipe) key.block).isPowered()) {
				cir.setReturnValue(sprites.getBlockSprite("pipeplus:block/active_redstone_pipe"));
			}
		}
	}
}