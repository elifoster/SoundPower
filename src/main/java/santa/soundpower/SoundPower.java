package santa.soundpower;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import santa.soundpower.block.SoundPowerBlocks;
import santa.soundpower.handler.SoundPowerEventHandler;
import santa.soundpower.item.SoundPowerItems;
import santa.soundpower.tile.TileNoiseFluxer;

@Mod(name = SoundPower.NAME, modid = SoundPower.MODID, version = SoundPower.VERSION)
public class SoundPower {

    public static final String NAME = "SoundPower";
    public static final String MODID = "soundpower";
    public static final String VERSION = "0.0.1";

    public static CreativeTabs tab;

    private static void registerTileEntity(Class<? extends TileEntity> clazz, String key) {
        GameRegistry.registerTileEntityWithAlternatives(clazz, MODID + ":" + key);
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.load(event);

        tab = new SoundPowerTab(CreativeTabs.getNextID(), MODID);

        SoundPowerBlocks.registerBlocks();
        SoundPowerItems.registerItems();

        registerTileEntity(TileNoiseFluxer.class, "noisefluxer");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SoundPowerEventHandler());

        SoundPowerBlocks.registerRecipes();
        SoundPowerItems.registerRecipes();
    }

    private class SoundPowerTab extends CreativeTabs {

        public SoundPowerTab(int id, String modid) {
            super(id, modid);
        }

        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.jukebox);
        }
    }
}
