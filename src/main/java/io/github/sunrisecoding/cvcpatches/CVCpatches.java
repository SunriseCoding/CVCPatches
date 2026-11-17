package io.github.sunrisecoding.cvcpatches;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CVCpatches.MODID)
public class CVCpatches {
    public static final String MODID = "cvcpatches";

    private static final Logger LOGGER = LogUtils.getLogger();
}
