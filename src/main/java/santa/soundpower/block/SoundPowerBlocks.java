package santa.soundpower.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class SoundPowerBlocks {

    public static Block noisefluxer;

    public static void registerBlocks() {
        noisefluxer = new BlockNoiseFluxer();
        GameRegistry.registerBlock(noisefluxer, "noisefluxer");
    }

    public static void registerRecipes() {}
}
