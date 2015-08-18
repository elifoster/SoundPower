package santa.soundpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import santa.soundpower.SoundPower;
import santa.soundpower.tile.TileNoiseFluxer;

public class BlockNoiseFluxer extends Block {

    public BlockNoiseFluxer(Material mat) {
        super(Material.iron);
        this.setCreativeTab(SoundPower.tab);
        this.setBlockTextureName("minecraft:jukebox");
        this.setBlockName(SoundPower.MODID + ":noisefluxer");
        this.setHardness(5.0F);
        this.setStepSound(Block.soundTypeAnvil);
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        return new TileNoiseFluxer();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        System.out.println(String.format("This Noise Fluxer has %d power.", TileNoiseFluxer.storage.getEnergyStored()));
        return false;
    }
}