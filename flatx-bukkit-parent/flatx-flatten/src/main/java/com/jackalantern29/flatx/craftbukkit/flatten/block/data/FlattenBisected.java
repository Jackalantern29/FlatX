package com.jackalantern29.flatx.craftbukkit.flatten.block.data;

import com.jackalantern29.flatx.api.block.data.FlatBisected;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockData;
import org.bukkit.block.data.Bisected;

public class FlattenBisected extends FlattenBlockData implements FlatBisected {
    private final Bisected bisected;

    public FlattenBisected(Bisected data) {
        super(data);
        this.bisected = data;
    }

    @Override
    public Half getHalf() {
        return Half.valueOf(bisected.getHalf().name());
    }

    @Override
    public void setHalf(Half half) {
        bisected.setHalf(Bisected.Half.valueOf(half.name()));
    }
}
