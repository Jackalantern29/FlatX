package com.jackalantern29.flatx.craftbukkit.legacy;

import com.jackalantern29.flatx.api.FlatWorld;
import org.bukkit.World;

public abstract class LegacyWorld implements FlatWorld {
    private final World world;

    public LegacyWorld(World world) {

        this.world = world;
    }

    public World toBukkit() {
        return world;
    }
}
