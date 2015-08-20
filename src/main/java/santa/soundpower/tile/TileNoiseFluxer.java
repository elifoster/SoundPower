package santa.soundpower.tile;

import cofh.api.energy.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import santa.soundpower.Config;

public class TileNoiseFluxer extends TileEnergyHandler implements IEnergyConnection, IEnergyProvider, IEnergyStorage {

    public static EnergyStorage storage = new EnergyStorage(Config.noisefluxerStorage);

    /* IEnergyConnection */
    @Override
    public boolean canConnectEnergy(ForgeDirection dir) {
        return true;
    }

    /* TileEnergyHandler */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        storage.writeToNBT(nbt);
    }

    /* IEnergyProvider */
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return storage.getMaxEnergyStored();
    }

    /* IEnergyStorage */
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored() {
        return storage.getMaxEnergyStored();
    }

    /* General */
    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    public static void increaseEnergy(float volume, float pitch) {
        TileNoiseFluxer tile = new TileNoiseFluxer();
        int energy = tile.getEnergyStored(ForgeDirection.DOWN);
        energy += (int) volume * (int) pitch;
        tile.receiveEnergy(energy, false);
    }

    public int[] getCoordinates() {
        int[] coords = {
          xCoord, yCoord, zCoord
        };

        return coords;
    }
}
