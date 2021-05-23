package com.jackalantern29.flatx.craftbukkit.flatten.block.data;

import com.jackalantern29.flatx.api.block.FlatBlockFace;
import com.jackalantern29.flatx.api.block.data.FlatDirectional;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockData;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;

import java.util.HashSet;
import java.util.Set;

public class FlattenDirectional extends FlattenBlockData implements FlatDirectional {
    private Directional directional;

    public FlattenDirectional(Directional data) {
        super(data);
        this.directional = data;
    }

    @Override
    public Set<FlatBlockFace> getFaces() {
        Set<FlatBlockFace> set = new HashSet<>();
        for(BlockFace face : directional.getFaces())
            set.add(FlatBlockFace.valueOf(face.name()));
        return set;
    }

    @Override
    public FlatBlockFace getFacing() {
        return FlatBlockFace.valueOf(directional.getFacing().name());
    }

    @Override
    public void setFacing(FlatBlockFace facing) {
        directional.setFacing(BlockFace.valueOf(facing.name()));
    }

    public Directional toBukkit() {
        return directional;
    }
}
