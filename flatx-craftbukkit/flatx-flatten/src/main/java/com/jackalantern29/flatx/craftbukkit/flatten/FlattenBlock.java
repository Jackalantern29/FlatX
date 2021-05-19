package com.jackalantern29.flatx.craftbukkit.flatten;

import com.jackalantern29.flatx.api.FlatBlock;
import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatBlockState;
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

    public Block getBlock() {
        return block;
    }
}
