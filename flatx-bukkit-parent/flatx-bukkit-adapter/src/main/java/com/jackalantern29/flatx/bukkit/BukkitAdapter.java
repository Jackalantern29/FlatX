package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.*;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

public class BukkitAdapter {
    static IBukkitAdapter adapter;

    public static FlatMaterial adapt(Material material) {
        return adapter.adapt(material);
    }

    public static <T> FlatBlockData adapt(T data) {
        return adapter.adapt(data);
    }

    public static FlatBlock adapt(Block block) {
        return adapter.adapt(block);
    }

    public static FlatBlockState adapt(BlockState state) {
        return adapter.adapt(state);
    }

    public static FlatWorld adapt(World world) {
        if(world == null)
            return null;
        return adapter.adapt(world);
    }

    public static FlatLocation adapt(Location location) {
        return adapter.adapt(location);
    }

    public static Material asBukkitMaterial(FlatMaterial material) {
        return adapter.asBukkitMaterial(material);
    }

    public static Object asBukkitBlockData(FlatBlockData data) {
        return adapter.asBukkitBlockData(data);
    }

    public static Block asBukkitBlock(FlatBlock block) {
        return adapter.asBukkitBlock(block);
    }

    public static BlockState asBukkitBlockState(FlatBlockState state) {
        return adapter.asBukkitBlockState(state);
    }

    public static Player asBukkitPlayer(FlatPlayer player) {
        return adapter.asBukkitPlayer(player);
    }

    public static World asBukkitWorld(FlatWorld world) {
        return adapter.asBukkitWorld(world);
    }

    public static Location asBukkitLocation(FlatLocation location) {
        return adapter.asBukkitLocation(location);
    }
}
