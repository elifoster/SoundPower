package santa.soundpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import santa.soundpower.SoundPower;
import santa.soundpower.tile.TileNoiseFluxer;

public class BlockNoiseFluxer extends Block implements ITileEntityProvider {

    public BlockNoiseFluxer() {
        super(Material.iron);
        this.setCreativeTab(SoundPower.tab);
        this.setBlockTextureName("minecraft:jukebox");
        this.setBlockName(SoundPower.MODID + ":noisefluxer");
        this.setHardness(5.0F);
        this.setStepSound(Block.soundTypeAnvil);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileNoiseFluxer();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if (tile != null && tile instanceof TileNoiseFluxer) {
            TileNoiseFluxer fluxer = (TileNoiseFluxer) world.getTileEntity(x, y, z);
            System.out.println(String.format("This Noise Fluxer has %d power.", fluxer.storage.getEnergyStored()));
        }
        return true;
    }
}
