package santa.soundpower.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import santa.soundpower.tile.TileNoiseFluxer;

public class SoundPowerEventHandler {


    @SubscribeEvent
    public void playSound(PlaySoundAtEntityEvent event) {
        World world = event.entity.worldObj;
        int x = (int) event.entity.posX;
        int y = (int) event.entity.posY;
        int z = (int) event.entity.posZ;

        float volume = event.volume;
        float pitch = event.pitch;
        TileNoiseFluxer.pitch = pitch;
        TileNoiseFluxer.volume = volume;
        TileNoiseFluxer.x = x;
        TileNoiseFluxer.y = y;
        TileNoiseFluxer.z = z;
        TileNoiseFluxer.isSoundPlaying = true;
    }
}
