package santa.soundpower.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SoundPowerBlocks {

    public static Block noisefluxer;

    public static void registerBlocks() {
        noisefluxer = new BlockNoiseFluxer(Material.iron);
        GameRegistry.registerBlock(noisefluxer, "noisefluxer");
    }

    public static void registerRecipes() {}
}
