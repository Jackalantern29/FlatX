package com.jackalantern29.flatx.craftbukkit.flatten;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

public class FlattenBlockData implements FlatBlockData {
    private final BlockData data;

    public FlattenBlockData(BlockData data) {
        this.data = data;
    }

    public FlattenBlockData(Material material) {
        this.data = material.createBlockData();
    }

    public FlattenBlockData(Material material, String data) {
        this.data = material.createBlockData(data);
    }

    @Override
    public FlatMaterial getMaterial() {
        return FlatMaterial.getMaterial(data.getMaterial().name());
    }

    @Override
    public String getAsString() {
        return data.getAsString();
    }

    public BlockData getData() {
        return data;
    }
}
