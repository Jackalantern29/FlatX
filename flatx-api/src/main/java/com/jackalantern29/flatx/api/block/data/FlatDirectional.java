package com.jackalantern29.flatx.api.block.data;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.block.FlatBlockFace;

import java.util.Set;

public interface FlatDirectional extends FlatBlockData {
    Set<FlatBlockFace> getFaces();
    FlatBlockFace getFacing();
    void setFacing(FlatBlockFace facing);
}
