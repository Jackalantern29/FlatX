package com.jackalantern29.flatx.api.block.data.type;

import com.jackalantern29.flatx.api.FlatBlockData;

public interface FlatPiston extends FlatBlockData {
    boolean isExtended();
    void setExtended(boolean extended);
}
