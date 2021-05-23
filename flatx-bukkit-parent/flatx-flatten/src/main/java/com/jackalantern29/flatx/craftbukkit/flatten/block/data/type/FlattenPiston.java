package com.jackalantern29.flatx.craftbukkit.flatten.block.data.type;

import com.jackalantern29.flatx.api.block.data.type.FlatPiston;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockData;
import org.bukkit.block.data.type.Piston;

public class FlattenPiston extends FlattenBlockData implements FlatPiston {
    private Piston piston;

    public FlattenPiston(Piston piston) {
        super(piston);
        this.piston = piston;
    }

    @Override
    public boolean isExtended() {
        return piston.isExtended();
    }

    @Override
    public void setExtended(boolean extended) {
        piston.setExtended(extended);
    }

    public Piston toBukkit() {
        return piston;
    }
}
