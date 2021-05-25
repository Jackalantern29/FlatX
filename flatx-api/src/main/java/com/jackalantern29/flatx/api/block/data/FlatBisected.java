package com.jackalantern29.flatx.api.block.data;

import com.jackalantern29.flatx.api.FlatBlockData;

public interface FlatBisected extends FlatBlockData {
    Half getHalf();
    void setHalf(Half half);

    enum Half {
        TOP,
        BOTTOM,
    }
}
