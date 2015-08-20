package santa.soundpower.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import santa.soundpower.tile.TileNoiseFluxer;

public class SoundPowerEventHandler {

    @SubscribeEvent
    public void playSound(PlaySoundAtEntityEvent event) {
        World world = event.entity.worldObj;
        int xEntity = (int) event.entity.posX;
        int yEntity = (int) event.entity.posY;
        int zEntity = (int) event.entity.posZ;

        float volume = event.volume;
        float pitch = event.pitch;

        for (int x = xEntity - 20; x < xEntity + 20; x++) {
            for (int y = yEntity - 20; y < yEntity + 20; y++) {
                for (int z = zEntity - 20; z < zEntity + 20; z++) {
                    TileEntity tile = world.getTileEntity(x, y, z);
                    if (tile != null && tile instanceof TileNoiseFluxer) {
                        TileNoiseFluxer fluxer = (TileNoiseFluxer) world.getTileEntity(xEntity, yEntity, zEntity);
                        int tileX = fluxer.getCoordinates()[0];
                    }
                }
            }
        }
        /*
        if (MathUtil.isBetween(tileX - 20, tileX + 20, soundX) &&
          MathUtil.isBetween(tileY - 20, tileY + 20, soundY) &&
          MathUtil.isBetween(tileZ - 20, tileZ + 20, soundZ)) {
            System.out.println(String.format("About to increase energy with volume %f and pitch %f", volume, pitch));
            TileNoiseFluxer.increaseEnergy(volume, pitch);
        }
        */
    }
}
