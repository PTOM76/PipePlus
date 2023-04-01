package ml.pkom.pipeplus.parts;

import alexiil.mc.mod.pipes.pipe.PartSpPipe;
import alexiil.mc.mod.pipes.pipe.PipeSpBehaviour;
import alexiil.mc.mod.pipes.pipe.PipeSpFlowItem;
import ml.pkom.pipeplus.PipePlus;
import alexiil.mc.mod.pipes.pipe.PipeSpDef.PipeDefFluid;
import alexiil.mc.mod.pipes.pipe.PipeSpDef.PipeDefItem;
import ml.pkom.pipeplus.pipe.*;
import ml.pkom.pipeplus.pipeflow.TeleportPipeFlow;
import ml.pkom.pipeplus.pipeflow.VoidPipeFlowItem;

public class PipePlusParts {
    private PipePlusParts() {

    }

    public static final PipeDefItem COPPER_ITEM_PIPE;
    public static final PipeDefItem TIN_ITEM_PIPE;
    public static final PipeDefItem SILVER_ITEM_PIPE;
    public static final PipeDefItem STACK_EXTRACT_ITEM_PIPE;
    public static final PipeDefItem REDSTONE_ITEM_PIPE;
    public static final PipeDefItem COBBLESTONE_ITEM_PIPE;
    public static final PipeDefItem VOID_ITEM_PIPE;
    public static final PipeDefItem OBSIDIAN_ITEM_PIPE;
    public static final PipeDefItem ENDER_PIPE;
    public static final PipeDefItem TELEPORT_ITEM_PIPE;
    public static final PipeDefItem RUBY_PIPE;
    public static final PipeDefItem EMERALD_PIPE;
    
    public static final PipeDefFluid COPPER_FLUID_PIPE;
    public static final PipeDefFluid TIN_FLUID_PIPE;
    public static final PipeDefFluid SILVER_FLUID_PIPE;

    static {
        COPPER_ITEM_PIPE = new PipeDefItem(PipePlus.id("copper_item_pipe"), true, false, 1) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourItemExtract(pipe, 20, 1);
            }
        };
        TIN_ITEM_PIPE = new PipeDefItem(PipePlus.id("tin_item_pipe"), true, false, 3) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourItemExtract(pipe, 10, 1);
            }
        };
        SILVER_ITEM_PIPE = new PipeDefItem(PipePlus.id("silver_item_pipe"), true, true, 6) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourItemExtract(pipe, 5, 1);
            }
        };
        STACK_EXTRACT_ITEM_PIPE = new PipeDefItem(PipePlus.id("stack_extract_pipe"), true, true, 6) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourItemExtract(pipe, 5, 64);
            }
        };
        REDSTONE_ITEM_PIPE = new PipeDefItem(PipePlus.id("redstone_item_pipe"), false, false, 1) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourRedstone(pipe);
            }
        };
        COBBLESTONE_ITEM_PIPE = new PipeDefItem(PipePlus.id("cobblestone_item_pipe"), false, false, 1);
        VOID_ITEM_PIPE = new PipeDefItem(PipePlus.id("void_item_pipe"), false, false, 1) {
            @Override
            public PipeSpFlowItem createFlow(PartSpPipe pipe) {
                return new VoidPipeFlowItem(pipe);
            }
        };
        OBSIDIAN_ITEM_PIPE = new PipeDefItem(PipePlus.id("obsidian_item_pipe"), true, false, 1) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourObsidian(pipe);
            }
        };
        ENDER_PIPE = new PipeDefItem(PipePlus.id("ender_pipe"), true, true, 1) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourEnder(pipe);
            }
        };
        TELEPORT_ITEM_PIPE = new PipeDefItem(PipePlus.id("teleport_item_pipe"), true, true, 1) {
            @Override
            public PipeSpFlowItem createFlow(PartSpPipe pipe) {
                return new TeleportPipeFlow(pipe);
            }

            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourTeleport(pipe);
            }
        };
        RUBY_PIPE = new PipeDefItem(PipePlus.id("ruby_pipe"), false, false, 12);
        EMERALD_PIPE = new PipeDefItem(PipePlus.id("emerald_pipe"), false, false, 9);

        COPPER_FLUID_PIPE = new PipeDefFluid(PipePlus.id("copper_fluid_pipe"), true) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourFluidExtract(pipe, 20);
            }
        };
        TIN_FLUID_PIPE = new PipeDefFluid(PipePlus.id("tin_fluid_pipe"), true) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourFluidExtract(pipe, 10);
            }
        };
        SILVER_FLUID_PIPE = new PipeDefFluid(PipePlus.id("silver_fluid_pipe"), true) {
            @Override
            public PipeSpBehaviour createBehaviour(PartSpPipe pipe) {
                return new PipeSpBehaviourFluidExtract(pipe, 5);
            }
        };
    }

    public static void init() {
        COPPER_ITEM_PIPE.register();
        TIN_ITEM_PIPE.register();
        SILVER_ITEM_PIPE.register();
        STACK_EXTRACT_ITEM_PIPE.register();
        REDSTONE_ITEM_PIPE.register();
        COBBLESTONE_ITEM_PIPE.register();
        VOID_ITEM_PIPE.register();
        OBSIDIAN_ITEM_PIPE.register();
        ENDER_PIPE.register();
        TELEPORT_ITEM_PIPE.register();
        RUBY_PIPE.register();
        EMERALD_PIPE.register();

        COPPER_FLUID_PIPE.register();
        TIN_FLUID_PIPE.register();
        SILVER_FLUID_PIPE.register();
    }
}
