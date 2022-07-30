package com.mimike.nominingdelay;

import com.mimike.nominingdelay.config.NoMiningDelayServerConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(NoMiningDelay.MOD_ID)
public class NoMiningDelay
{
    public static final String MOD_ID = "nominingdelay";

    public NoMiningDelay()
    {
        ModLoadingContext.get()
            .registerConfig(
                ModConfig.Type.SERVER,
                NoMiningDelayServerConfig.SPEC,
                "NoMiningDelay-server.toml"
            );
    }
}
