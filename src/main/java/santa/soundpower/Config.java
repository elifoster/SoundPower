package santa.soundpower;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraftforge.common.config.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Config {

    public static int noisefluxerStorage;
    public static int noisefluxerRange;

    public static void load(FMLPreInitializationEvent event) {
        File configurationDir = ReflectionHelper.getPrivateValue(FMLPreInitializationEvent.class, event, 2);
        File oldConfigFile = new File(configurationDir, "Steamcraft.cfg");
        if (oldConfigFile.exists()) {
            try {
                FileUtils.copyFile(new File(configurationDir, "Steamcraft.cfg"), new File(configurationDir, "FlaxbeardsSteamPower.cfg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            oldConfigFile.delete();
        }
        Configuration config = new Configuration(new File(configurationDir, "FlaxbeardsSteamPower.cfg"));
        config.load();

        noisefluxerStorage = config.get("Tweaking", "Amount of RF that the Noise Fluxer can hold", 32000).getInt(32000);
        noisefluxerRange = config.get("Tweaking", "Range of noise that the Noise Fluxer will hear from", 80).getInt(80);

        config.save();
    }
}
