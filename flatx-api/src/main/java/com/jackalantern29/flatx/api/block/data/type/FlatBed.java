package com.jackalantern29.flatx.api.block.data.type;

import com.jackalantern29.flatx.api.block.data.FlatDirectional;

public interface FlatBed extends FlatDirectional {
    Part getPart();
    boolean isOccupied();
    void setPart(Part part);

    enum Part {
        HEAD,
        FOOT,
    }
}
