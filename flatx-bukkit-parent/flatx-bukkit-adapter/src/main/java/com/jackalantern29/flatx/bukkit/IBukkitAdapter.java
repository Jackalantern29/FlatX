package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.*;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

public interface IBukkitAdapter {
    FlatMaterial adapt(Material material);
    <T> FlatBlockData adapt(T data);
    FlatBlock adapt(Block block);
    FlatBlockState adapt(BlockState blockState);
    FlatWorld adapt(World world);
    FlatLocation adapt(Location location);
    Material asBukkitMaterial(FlatMaterial material);
    <T> T asBukkitBlockData(FlatBlockData data);
    Block asBukkitBlock(FlatBlock block);
    BlockState asBukkitBlockState(FlatBlockState state);
    Player asBukkitPlayer(FlatPlayer player);
    World asBukkitWorld(FlatWorld world);
    Location asBukkitLocation(FlatLocation location);
}
