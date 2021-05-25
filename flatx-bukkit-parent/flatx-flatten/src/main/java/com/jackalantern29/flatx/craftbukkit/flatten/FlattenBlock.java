package com.jackalantern29.flatx.craftbukkit.flatten;

import com.jackalantern29.flatx.api.FlatBlock;
import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatBlockState;
import com.jackalantern29.flatx.api.FlatLocation;
import org.bukkit.block.Block;

public class FlattenBlock implements FlatBlock {
    private final Block block;

    public FlattenBlock(Block block) {
        this.block = block;
    }

    @Override
    public FlatBlockData getBlockData() {
        return new FlattenBlockData(block.getBlockData());
    }

    @Override
    public FlatBlockState getState() {
        return new FlattenBlockState(block.getState());
    }

    @Override
    public FlatLocation getLocation() {
        return new FlatLocation(null/*CraftFlattenAdapter.adapt((World)null)*/, block.getX(), block.getY(), block.getZ());
    }

    @Override
    public void setBlockData(FlatBlockData data) {
        setBlockData(data, true);
    }

    @Override
    public void setBlockData(FlatBlockData data, boolean applyPhysics) {
        block.setBlockData(((FlattenBlockData)data).toBukkit(), applyPhysics);
    }

    public Block toBukkit() {
        return block;
    }
}
