package com.jackalantern29.flatx.bukkit.craftbukkit.flatten;

import com.jackalantern29.flatx.api.*;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.IBukkitAdapter;
import com.jackalantern29.flatx.bukkit.VersionUtil;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlock;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockData;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public class FlattenBukkitAdapter implements IBukkitAdapter {

    @Override
    public FlatMaterial adapt(Material material) {
        return FlatMaterial.getMaterial(material.name(), false);
    }

    @Override
    public <T> FlatBlockData adapt(T data) {
        return new FlattenBlockData((BlockData)data);
    }

    @Override
    public FlatBlock adapt(Block block) {
        return new FlattenBlock(block);
    }

    @Override
    public FlatBlockState adapt(BlockState blockState) {
        return new FlattenBlockState(blockState);
    }

    @Override
    public FlatPlayer adapt(Player player) {
        if(player == null)
            return null;
        switch(VersionUtil.getBukkitVersionID()) {
            case 9: return new com.jackalantern29.flatx.craftbukkit.v1_13_R1.XPlayer(player);
            case 10: return new com.jackalantern29.flatx.craftbukkit.v1_13_R2.XPlayer(player);
            case 11: return new com.jackalantern29.flatx.craftbukkit.v1_14_R1.XPlayer(player);
            case 12: return new com.jackalantern29.flatx.craftbukkit.v1_15_R1.XPlayer(player);
            case 13: return new com.jackalantern29.flatx.craftbukkit.v1_16_R1.XPlayer(player);
            case 14: return new com.jackalantern29.flatx.craftbukkit.v1_16_R2.XPlayer(player);
            case 15: return new com.jackalantern29.flatx.craftbukkit.v1_16_R3.XPlayer(player);
            default: return null;
        }
    }

    @Override
    public FlatWorld adapt(World world) {
        if(world == null)
            return null;
        switch(VersionUtil.getBukkitVersionID()) {
            case 9: return new com.jackalantern29.flatx.craftbukkit.v1_13_R1.XWorld(world);
            case 10: return new com.jackalantern29.flatx.craftbukkit.v1_13_R2.XWorld(world);
            case 11: return new com.jackalantern29.flatx.craftbukkit.v1_14_R1.XWorld(world);
            case 12: return new com.jackalantern29.flatx.craftbukkit.v1_15_R1.XWorld(world);
            case 13: return new com.jackalantern29.flatx.craftbukkit.v1_16_R1.XWorld(world);
            case 14: return new com.jackalantern29.flatx.craftbukkit.v1_16_R2.XWorld(world);
            case 15: return new com.jackalantern29.flatx.craftbukkit.v1_16_R3.XWorld(world);
            default: return null;
        }
    }

    @Override
    public FlatLocation adapt(Location location) {
        return new FlatLocation(adapt(location.getWorld()), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    @Override
    public Material asBukkitMaterial(FlatMaterial material) {
        return Material.valueOf(material.name());
    }

    @Override
    public BlockData asBukkitBlockData(FlatBlockData data) {
        return ((FlattenBlockData)data).toBukkit();
    }

    @Override
    public Block asBukkitBlock(FlatBlock block) {
        return null;
    }

    @Override
    public BlockState asBukkitBlockState(FlatBlockState state) {
        return null;
    }

    @Override
    public Player asBukkitPlayer(FlatPlayer player) {
        return null;
    }

    @Override
    public World asBukkitWorld(FlatWorld world) {
        return null;
    }

    @Override
    public Location asBukkitLocation(FlatLocation location) {
        return null;
    }
}
