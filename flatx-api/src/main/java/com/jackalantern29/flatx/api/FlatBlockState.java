package com.jackalantern29.flatx.api;

public interface FlatBlockState {
    FlatBlockData getBlockData();
    void setBlockData(FlatBlockData data);
    boolean update();
    boolean update(boolean force);
    boolean update(boolean force, boolean applyPhysics);
}
