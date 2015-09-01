package santa.soundpower.tile;

import cofh.api.energy.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import santa.soundpower.Config;

public class TileNoiseFluxer extends TileEnergyHandler implements IEnergyConnection, IEnergyProvider, IEnergyStorage {

    public static EnergyStorage storage = new EnergyStorage(Config.noisefluxerStorage);
    public static int x, y, z;
    public static float volume, pitch;
    public static boolean isSoundPlaying;

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
        if (this.isSoundPlaying && this.worldObj.isRemote) {
            increaseEnergy(this.volume, this.pitch, this.x, this.y, this.z);
        }
    }

    public void increaseEnergy(float v, float p, int x, int y, int z) {
        this.isSoundPlaying = false;
        System.out.println("increasing energy");
        if (Math.sqrt(this.getDistanceFrom((double) x, (double) y, (double) z)) < Config.noisefluxerRange) {
            int energy = this.getEnergyStored();
            energy += (int) v * (int) p;
            this.receiveEnergy(energy, false);
            System.out.println(String.format("Increased energy by %d", energy));
        } else {
            System.out.println(String.format("Could not increase energy. getDistanceFrom resulted in %d, while the range is %d", (int) getDistanceFrom((double) x, (double) y, (double) z), Config.noisefluxerRange));
        }
    }
}
