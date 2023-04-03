package ml.pkom.pipeplus.pipe;

import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;

import alexiil.mc.lib.multipart.api.property.MultipartProperties;
import alexiil.mc.lib.multipart.api.property.MultipartPropertyContainer;

public class PipeSpBehaviourRedstone extends PipeSpBehaviour {

    public PipeSpBehaviourRedstone(PartSpPipe pipe) {
        super(pipe);
    }

    @Override
    public void tick() {
        super.tick();
        World world = pipe.getPipeWorld();
        if (world == null) return;
        if (!world.isClient) {
            MultipartPropertyContainer properties = pipe.container.getProperties();

            if (((PipeSpFlowItem) pipe.getFlow()).getAllItemsForRender().isEmpty()) {
                properties.clearValue(pipe, MultipartProperties.getStrongRedstonePower(Direction.UP));
                for (Direction dir : Direction.values()) {
                    properties.clearValue(pipe, MultipartProperties.getWeakRedstonePower(dir));
                }
            } else {
                properties.setValue(pipe, MultipartProperties.getStrongRedstonePower(Direction.UP), 15);
                for (Direction dir : Direction.values()) {
                    properties.setValue(pipe, MultipartProperties.getWeakRedstonePower(dir), 15);
                }
            }
        }
    }
}
