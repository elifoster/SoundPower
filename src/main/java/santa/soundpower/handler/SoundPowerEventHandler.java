package santa.soundpower.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent17;
import santa.soundpower.tile.TileNoiseFluxer;
import santa.soundpower.util.MathUtil;

public class SoundPowerEventHandler {

    @SubscribeEvent
    public void playSound(PlaySoundEvent17 event) {
        int tileX = TileNoiseFluxer.getCoordinates()[0];
        int tileY = TileNoiseFluxer.getCoordinates()[1];
        int tileZ = TileNoiseFluxer.getCoordinates()[2];
        int soundX = (int) event.sound.getXPosF();
        int soundY = (int) event.sound.getYPosF();
        int soundZ = (int) event.sound.getZPosF();
        float volume = event.sound.getVolume();
        float pitch = event.sound.getPitch();

        if (MathUtil.isBetween(tileX - 20, tileX + 20, soundX) &&
          MathUtil.isBetween(tileY - 20, tileY + 20, soundY) &&
          MathUtil.isBetween(tileZ - 20, tileZ + 20, soundZ)) {
            System.out.println(String.format("About to increase energy with volume %f and pitch %f", volume, pitch));
            TileNoiseFluxer.increaseEnergy(volume, pitch);
        }
    }
}
