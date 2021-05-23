package com.jackalantern29.flatx.api.block.data.type;

import com.jackalantern29.flatx.api.block.data.FlatDirectional;

public interface FlatChest extends FlatDirectional {
    Type getType();
    void setType(Type type);

    enum Type {
        LEFT,
        RIGHT,
        SINGLE,
    }
}
