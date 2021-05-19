package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.FlatBlock;
import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatBlockState;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlock;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockData;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockState;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlock;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockData;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;

public class BukkitAdapter {
    public static FlatMaterial adapt(Material material) {
        return FlatMaterial.getMaterial(material.name(), !VersionUtil.isFlatVersion());
    }

    public static FlatBlockData adapt(MaterialData data) {
        return new LegacyBlockData(data);
    }

    public static FlatBlockData adapt(BlockData data) {
        return new FlattenBlockData(data);
    }

    public static FlatBlock adapt(Block block) {
        if(VersionUtil.isFlatVersion())
            return new FlattenBlock(block);
        else
            return new LegacyBlock(block);
    }

    public static FlatBlockState adapt(BlockState state) {
        if(VersionUtil.isFlatVersion())
            return new FlattenBlockState(state);
        else
            return new LegacyBlockState(state);
    }

    public static Object adapt(Object object) {
        if(object instanceof Material)
            return adapt((Material)object);
        else if(object instanceof MaterialData)
            return adapt((MaterialData)object);
        else if(object instanceof BlockData)
            return adapt((BlockData)object);
        else if(object instanceof Block)
            return adapt((Block)object);
        else if(object instanceof BlockState)
            return adapt((BlockState)object);
        else
            return null;
    }

    public static Material asBukkitMaterial(FlatMaterial material) {
        if(VersionUtil.isFlatVersion())
            return Material.valueOf(material.name());
        else
            return Material.valueOf(material.getLegacyName());
    }

    public static MaterialData asBukkitMaterialData(FlatBlockData data) {
        if(VersionUtil.isFlatVersion() || !(data instanceof LegacyBlockData))
            return null;
        LegacyBlockData legacyData = (LegacyBlockData) data;
        return legacyData.getData();
    }

    public static BlockData asBukkitBlockData(FlatBlockData data) {
        if(!VersionUtil.isFlatVersion() || !(data instanceof FlattenBlockData))
            return null;
        FlattenBlockData flatData = (FlattenBlockData) data;
        return flatData.getData();
    }

    public static Object asBukkitData(FlatBlockData data) {
        if(data instanceof FlattenBlockData)
            return asBukkitBlockData(data);
        else if(data instanceof LegacyBlockData)
            return asBukkitMaterialData(data);
        else
            return null;
    }

    public static Block asBukkitBlock(FlatBlock block) {
        if(VersionUtil.isFlatVersion())
            return ((FlattenBlock)block).getBlock();
        else
            return ((LegacyBlock)block).getBlock();
    }

    public static BlockState asBukkitBlockState(FlatBlockState state) {
        if(VersionUtil.isFlatVersion())
            return ((FlattenBlockState)state).getBlockState();
        else
            return ((LegacyBlockState)state).getBlockState();
    }
}
