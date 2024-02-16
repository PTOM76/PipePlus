package net.pitan76.pipeplus.addon;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.pitan76.pipeplus.config.PipePlusConfig;

@Environment(EnvType.CLIENT)
public class ModMenuAddon implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(PipePlusConfig.class, parent).get();
    }
}
