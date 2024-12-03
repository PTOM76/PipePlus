package net.pitan76.pipeplus.parts;

import alexiil.mc.mod.pipes.pipe.PipeSpDef;
import net.pitan76.pipeplus.PipePlus;

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

        COPPER_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("copper_item_pipe"), true, false, 1);
        TIN_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("tin_item_pipe"), true, false, 3);
        SILVER_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("silver_item_pipe"), true, true, 6);
        STACK_EXTRACT_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("stack_extract_pipe"), true, true, 6);

        COPPER_FLUID_PIPE = new PipeSpDef.PipeDefFluid(PipePlus.instance.id("copper_fluid_pipe"), true);
        TIN_FLUID_PIPE = new PipeSpDef.PipeDefFluid(PipePlus.instance.id("tin_fluid_pipe"), true);
        SILVER_FLUID_PIPE = new PipeSpDef.PipeDefFluid(PipePlus.instance.id("silver_fluid_pipe"), true);

        REDSTONE_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("redstone_item_pipe"), false, false, 1);
        COBBLESTONE_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("cobblestone_item_pipe"), false, false, 1);
        VOID_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("void_item_pipe"), false, false, 1);
        OBSIDIAN_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("obsidian_item_pipe"), true, false, 1);
        ENDER_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("ender_pipe"), true, true, 1);
        TELEPORT_ITEM_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("teleport_item_pipe"), true, true, 1);

        RUBY_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("ruby_pipe"), false, false, 12);
        EMERALD_PIPE = new PipeSpDef.PipeDefItem(PipePlus.instance.id("emerald_pipe"), false, false, 6);
    }

    public static void init() {
        COPPER_ITEM_PIPE.register();
        TIN_ITEM_PIPE.register();
        SILVER_ITEM_PIPE.register();
        STACK_EXTRACT_ITEM_PIPE.register();

        COPPER_FLUID_PIPE.register();
        TIN_FLUID_PIPE.register();
        SILVER_FLUID_PIPE.register();

        REDSTONE_ITEM_PIPE.register();
        COBBLESTONE_ITEM_PIPE.register();
        VOID_ITEM_PIPE.register();
        OBSIDIAN_ITEM_PIPE.register();
        ENDER_PIPE.register();
        TELEPORT_ITEM_PIPE.register();

        RUBY_PIPE.register();
        EMERALD_PIPE.register();
    }
}
