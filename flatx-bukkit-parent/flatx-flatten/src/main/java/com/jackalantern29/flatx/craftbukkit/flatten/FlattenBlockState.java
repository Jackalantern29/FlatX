package com.jackalantern29.flatx.craftbukkit.flatten;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatBlockState;
import org.bukkit.block.BlockState;

public class FlattenBlockState implements FlatBlockState {
    private final BlockState state;

    public FlattenBlockState(BlockState state) {
        this.state = state;
    }

    @Override
    public FlatBlockData getBlockData() {
        return new FlattenBlockData(state.getBlockData());
    }

    @Override
    public void setBlockData(FlatBlockData data) {
        if(data instanceof FlattenBlockData)
           state.setBlockData(((FlattenBlockData)data).toBukkit());
    }

    public BlockState toBukkit() {
        return state;
    }
}
