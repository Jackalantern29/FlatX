package com.jackalantern29.flatx.craftbukkit.legacy;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatBlockState;
import org.bukkit.block.BlockState;

public class LegacyBlockState implements FlatBlockState {
    private final BlockState state;

    public LegacyBlockState(BlockState state) {
        this.state = state;
    }

    @Override
    public FlatBlockData getBlockData() {
        return new LegacyBlockData(state.getData());
    }

    @Override
    public void setBlockData(FlatBlockData data) {
        if(data instanceof LegacyBlockData)
            state.setData(((LegacyBlockData)data).toBukkit());
    }

    @Override
    public boolean update() {
        return state.update();
    }

    @Override
    public boolean update(boolean force) {
        return state.update(force);
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        return state.update(force, applyPhysics);
    }
    public BlockState toBukkit() {
        return state;
    }
}
