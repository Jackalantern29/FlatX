package com.jackalantern29.flatx.bukkit.craftbukkit.flatten;

import com.jackalantern29.flatx.api.*;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.IBukkitAdapter;
import com.jackalantern29.flatx.bukkit.VersionUtil;
import com.jackalantern29.flatx.craftbukkit.flatten.*;
import com.jackalantern29.flatx.craftbukkit.flatten.block.data.FlattenChest;
import com.jackalantern29.flatx.craftbukkit.flatten.block.FlattenContainer;
import com.jackalantern29.flatx.craftbukkit.flatten.block.data.FlattenDirectional;
import com.jackalantern29.flatx.craftbukkit.flatten.block.data.type.FlattenPiston;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.Container;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Piston;
import org.bukkit.entity.Player;

public class FlattenBukkitAdapter implements IBukkitAdapter {

    @Override
    public FlatMaterial adapt(Material material) {
        return FlatMaterial.getMaterial(material.name(), false);
    }

    @Override
    public <T> FlatBlockData adapt(T data) {
        if(data instanceof Piston)
            return new FlattenPiston((Piston)data);
        else if(data instanceof Chest)
            return new com.jackalantern29.flatx.craftbukkit.flatten.block.data.type.FlattenChest((org.bukkit.block.data.type.Chest) data);
        else if(data instanceof Directional)
            return new FlattenDirectional((Directional)data);
        return new FlattenBlockData((BlockData)data);
    }

    @Override
    public FlatBlock adapt(Block block) {
        return new FlattenBlock(block);
    }

    @Override
    public FlatBlockState adapt(BlockState state) {
        if(state instanceof Container) {
            if(state instanceof Chest)
                return new FlattenChest((Chest) state);
            return new FlattenContainer((Container)state);
        }
        return new FlattenBlockState(state);
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
        return ((FlattenBlock)block).toBukkit();
    }

    @Override
    public BlockState asBukkitBlockState(FlatBlockState state) {
        return ((FlattenBlockState)state).toBukkit();
    }

    @Override
    public Player asBukkitPlayer(FlatPlayer player) {
        return ((FlattenPlayer)player).toBukkit();
    }

    @Override
    public World asBukkitWorld(FlatWorld world) {
        return ((FlattenWorld)world).toBukkit();
    }

    @Override
    public Location asBukkitLocation(FlatLocation location) {
        return new Location(asBukkitWorld(location.getWorld()), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }
}
