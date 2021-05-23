package com.jackalantern29.flatx.craftbukkit.legacy.block.data;

import com.jackalantern29.flatx.api.block.FlatBlockFace;
import com.jackalantern29.flatx.api.block.data.FlatDirectional;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockData;
import org.bukkit.block.BlockFace;
import org.bukkit.material.DirectionalContainer;

import java.util.Set;

public class LegacyDirectional extends LegacyBlockData implements FlatDirectional {
    private DirectionalContainer directional;

    public LegacyDirectional(DirectionalContainer data) {
        super(data);
        this.directional = data;
    }

    @Override
    public Set<FlatBlockFace> getFaces() {
        return null; //TODO
    }

    @Override
    public FlatBlockFace getFacing() {
        return FlatBlockFace.valueOf(directional.getFacing().name());
    }

    @Override
    public void setFacing(FlatBlockFace facing) {
        directional.setFacingDirection(BlockFace.valueOf(facing.name()));
    }

    public DirectionalContainer toBukkit() {
        return directional;
    }
}
