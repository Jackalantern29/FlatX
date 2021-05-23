package com.jackalantern29.flatx.craftbukkit.flatten.block.data.type;

import com.jackalantern29.flatx.api.block.data.type.FlatChest;
import com.jackalantern29.flatx.craftbukkit.flatten.block.data.FlattenDirectional;
import org.bukkit.block.data.type.Chest;

public class FlattenChest extends FlattenDirectional implements FlatChest {
    private Chest chest;
    public FlattenChest(Chest data) {
        super(data);
        this.chest = data;
    }

    @Override
    public Type getType() {
        return Type.valueOf(chest.getType().name());
    }

    @Override
    public void setType(Type type) {
        chest.setType(Chest.Type.valueOf(type.name()));
    }

    public Chest toBukkit() {
        return chest;
    }
}
