package ml.pkom.pipeplus.parts;

import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import ml.pkom.pipeplus.PipePlus;

public class PipePlusParts {
    private PipePlusParts() {

    }

    public static final PipeSpDef.PipeDefItem COPPER_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem TIN_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem SILVER_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem STACK_EXTRACT_ITEM_PIPE;

    public static final PipeSpDef.PipeDefFluid COPPER_FLUID_PIPE;
    public static final PipeSpDef.PipeDefFluid TIN_FLUID_PIPE;
    public static final PipeSpDef.PipeDefFluid SILVER_FLUID_PIPE;

    public static final PipeSpDef.PipeDefItem REDSTONE_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem COBBLESTONE_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem VOID_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem OBSIDIAN_ITEM_PIPE;
    public static final PipeSpDef.PipeDefItem ENDER_PIPE;
    public static final PipeSpDef.PipeDefItem TELEPORT_ITEM_PIPE;

    public static final PipeSpDef.PipeDefItem RUBY_PIPE;
    public static final PipeSpDef.PipeDefItem EMERALD_PIPE;

    static {

        COPPER_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("copper_item_pipe"), true, false, 1);
        TIN_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("tin_item_pipe"), true, false, 3);
        SILVER_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("silver_item_pipe"), true, true, 6);
        STACK_EXTRACT_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("stack_extract_pipe"), true, true, 6);

        COPPER_FLUID_PIPE = new PipeSpDef.PipeDefFluid(PipePlus.id("copper_fluid_pipe"), true);
        TIN_FLUID_PIPE = new PipeSpDef.PipeDefFluid(PipePlus.id("tin_fluid_pipe"), true);
        SILVER_FLUID_PIPE = new PipeSpDef.PipeDefFluid(PipePlus.id("silver_fluid_pipe"), true);

        REDSTONE_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("redstone_item_pipe"), false, false, 1);
        COBBLESTONE_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("cobblestone_item_pipe"), false, false, 1);
        VOID_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("void_item_pipe"), false, false, 1);
        OBSIDIAN_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("obsidian_item_pipe"), true, false, 1);
        ENDER_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("ender_pipe"), true, true, 1);
        TELEPORT_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("teleport_item_pipe"), true, true, 1);

        RUBY_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("ruby_pipe"), false, false, 12);
        EMERALD_PIPE = new PipeSpDef.PipeDefItem(PipePlus.id("emerald_pipe"), false, false, 6);
    }
}
