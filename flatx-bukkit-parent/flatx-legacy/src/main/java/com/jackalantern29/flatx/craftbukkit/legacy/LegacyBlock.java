package com.jackalantern29.flatx.craftbukkit.legacy;

import com.jackalantern29.flatx.api.FlatBlock;
import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatBlockState;
import com.jackalantern29.flatx.api.FlatLocation;
import com.jackalantern29.flatx.bukkit.BukkitAdapter;
import org.bukkit.block.Block;

public class LegacyBlock implements FlatBlock {
    private final Block block;

    public LegacyBlock(Block block) {
        this.block = block;
    }

    @Override
    public FlatBlockData getBlockData() {
        return new LegacyBlockData(block.getType(), block.getData());
    }

    @Override
    public FlatBlockState getState() {
        return new LegacyBlockState(block.getState());
    }

    @Override
    public FlatLocation getLocation() {
        return new FlatLocation(BukkitAdapter.adapt(block.getWorld()), block.getX(), block.getY(), block.getZ());
    }
    public Block toBukkit() {
        return block;
    }
}
