package com.jackalantern29.flatx.craftbukkit.legacy.block.data;

import com.jackalantern29.flatx.api.block.data.FlatBisected;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockData;
import org.bukkit.material.Door;
import org.bukkit.material.MaterialData;

public class LegacyBisected extends LegacyBlockData implements FlatBisected {
    private final MaterialData bisected;

    public LegacyBisected(MaterialData data) {
        super(data);
        this.bisected = data;
    }

    @Override
    public Half getHalf() {
        if(bisected instanceof Door)
            return ((Door)bisected).isTopHalf() ? Half.TOP : Half.BOTTOM;
        return null;
    }

    @Override
    public void setHalf(Half half) {
        if(bisected instanceof Door)
            ((Door)bisected).setTopHalf(half == Half.TOP);
    }
}
