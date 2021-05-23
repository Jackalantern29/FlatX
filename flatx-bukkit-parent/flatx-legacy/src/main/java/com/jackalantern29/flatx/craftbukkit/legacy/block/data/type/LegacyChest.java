package com.jackalantern29.flatx.craftbukkit.legacy.block.data.type;

import com.jackalantern29.flatx.api.block.data.type.FlatChest;
import com.jackalantern29.flatx.craftbukkit.legacy.block.data.LegacyDirectional;
import org.bukkit.material.Chest;

public class LegacyChest extends LegacyDirectional implements FlatChest {
    private Chest chest;

    public LegacyChest(Chest data) {
        super(data);
        this.chest = data;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public void setType(Type type) {
    }

    public Chest toBukkit() {
        return chest;
    }
}
