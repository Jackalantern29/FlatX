package com.jackalantern29.flatx.bukkit.craftbukkit.legacy;

import com.jackalantern29.flatx.api.*;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.IBukkitAdapter;
import com.jackalantern29.flatx.bukkit.VersionUtil;
import com.jackalantern29.flatx.craftbukkit.legacy.*;
import com.jackalantern29.flatx.craftbukkit.legacy.block.data.LegacyChest;
import com.jackalantern29.flatx.craftbukkit.legacy.block.data.LegacyDirectional;
import com.jackalantern29.flatx.craftbukkit.legacy.block.data.type.LegacyPiston;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.material.DirectionalContainer;
import org.bukkit.material.MaterialData;
import org.bukkit.material.PistonBaseMaterial;

public class LegacyBukkitAdapter implements IBukkitAdapter {

    @Override
    public FlatMaterial adapt(Material material) {
        return FlatMaterial.getMaterial(material.name(), true);
    }

    @Override
    public <T> FlatBlockData adapt(T data) {
        if(data instanceof PistonBaseMaterial)
            return new LegacyPiston((PistonBaseMaterial)data);
        else if(data instanceof Chest)
            return new com.jackalantern29.flatx.craftbukkit.legacy.block.data.type.LegacyChest((org.bukkit.material.Chest) data);
        else if(data instanceof DirectionalContainer)
            return new LegacyDirectional((DirectionalContainer)data);
        return new LegacyBlockData((MaterialData)data);
    }

    @Override
    public FlatBlock adapt(Block block) {
        return new LegacyBlock(block);
    }

    @Override
    public FlatBlockState adapt(BlockState state) {
        if(state instanceof Chest)
            return new LegacyChest((Chest) state);
        return new LegacyBlockState(state);
    }

    @Override
    public FlatPlayer adapt(Player player) {
        if(player == null)
            return null;
        switch(VersionUtil.getBukkitVersionID()) {
            case 1: return new com.jackalantern29.flatx.craftbukkit.v1_8_R1.XPlayer(player);
            case 2: return new com.jackalantern29.flatx.craftbukkit.v1_8_R2.XPlayer(player);
            case 3: return new com.jackalantern29.flatx.craftbukkit.v1_8_R3.XPlayer(player);
            case 4: return new com.jackalantern29.flatx.craftbukkit.v1_9_R1.XPlayer(player);
            case 5: return new com.jackalantern29.flatx.craftbukkit.v1_9_R2.XPlayer(player);
            case 6: return new com.jackalantern29.flatx.craftbukkit.v1_10_R1.XPlayer(player);
            case 7: return new com.jackalantern29.flatx.craftbukkit.v1_11_R1.XPlayer(player);
            case 8: return new com.jackalantern29.flatx.craftbukkit.v1_12_R1.XPlayer(player);
            default: return null;
        }
    }

    @Override
    public FlatWorld adapt(World world) {
        if(world == null)
            return null;
        switch(VersionUtil.getBukkitVersionID()) {
            case 1: return new com.jackalantern29.flatx.craftbukkit.v1_8_R1.XWorld(world);
            case 2: return new com.jackalantern29.flatx.craftbukkit.v1_8_R2.XWorld(world);
            case 3: return new com.jackalantern29.flatx.craftbukkit.v1_8_R3.XWorld(world);
            case 4: return new com.jackalantern29.flatx.craftbukkit.v1_9_R1.XWorld(world);
            case 5: return new com.jackalantern29.flatx.craftbukkit.v1_9_R2.XWorld(world);
            case 6: return new com.jackalantern29.flatx.craftbukkit.v1_10_R1.XWorld(world);
            case 7: return new com.jackalantern29.flatx.craftbukkit.v1_11_R1.XWorld(world);
            case 8: return new com.jackalantern29.flatx.craftbukkit.v1_12_R1.XWorld(world);
            default: return null;
        }
    }

    @Override
    public FlatLocation adapt(Location location) {
        return new FlatLocation(adapt(location.getWorld()), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    @Override
    public Material asBukkitMaterial(FlatMaterial material) {
        return Material.valueOf(material.getLegacyName());
    }

    @Override
    public MaterialData asBukkitBlockData(FlatBlockData data) {
        return ((LegacyBlockData)data).toBukkit();
    }

    @Override
    public Block asBukkitBlock(FlatBlock block) {
        return ((LegacyBlock)block).toBukkit();
    }

    @Override
    public BlockState asBukkitBlockState(FlatBlockState state) {
        return ((LegacyBlockState)state).toBukkit();
    }

    @Override
    public Player asBukkitPlayer(FlatPlayer player) {
        return ((LegacyPlayer)player).toBukkit();
    }

    @Override
    public World asBukkitWorld(FlatWorld world) {
        return ((LegacyWorld)world).toBukkit();
    }

    @Override
    public Location asBukkitLocation(FlatLocation location) {
        return new Location(asBukkitWorld(location.getWorld()), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }
}
