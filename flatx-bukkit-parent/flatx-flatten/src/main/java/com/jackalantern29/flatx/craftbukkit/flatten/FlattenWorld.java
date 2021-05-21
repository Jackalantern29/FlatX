package com.jackalantern29.flatx.craftbukkit.flatten;

import com.jackalantern29.flatx.api.FlatWorld;
import org.bukkit.World;

public abstract class FlattenWorld implements FlatWorld {
    private final World world;

    public FlattenWorld(World world) {

        this.world = world;
    }

    public World toBukkit() {
        return world;
    }
}
