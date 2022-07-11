package ml.pkom.pipeplus.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import ml.pkom.pipeplus.PipePlus;

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
