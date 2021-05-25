package com.jackalantern29.flatx.api;

public interface FlatBlock {
    FlatBlockData getBlockData();
    FlatBlockState getState();
    FlatLocation getLocation();
    void setBlockData(FlatBlockData data);
    void setBlockData(FlatBlockData data, boolean applyPhysics);
}
