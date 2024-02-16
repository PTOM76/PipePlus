package net.pitan76.pipeplus.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import net.pitan76.pipeplus.PipePlus;

@Config(name = PipePlus.MOD_ID)
public class PipePlusConfig implements ConfigData {

    public static PipePlusConfig getConfig() {
        return AutoConfig.getConfigHolder(PipePlusConfig.class).getConfig();
    }

    public int copperTransportExtractDelay = 20;

    public int tinTransportExtractDelay = 10;

    public int silverTransportExtractDelay = 4;

    public int copperFluidExtractDelay = 20;

    public int tinFluidExtractDelay = 10;

    public int silverFluidExtractDelay = 4;

    public int stackTransportExtractDelay = 4;

}
