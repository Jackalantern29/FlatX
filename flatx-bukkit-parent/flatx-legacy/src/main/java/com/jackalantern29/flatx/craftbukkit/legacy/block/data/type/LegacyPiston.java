package com.jackalantern29.flatx.craftbukkit.legacy.block.data.type;

import com.jackalantern29.flatx.api.block.data.type.FlatPiston;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockData;
import org.bukkit.material.PistonBaseMaterial;

public class LegacyPiston extends LegacyBlockData implements FlatPiston {
    PistonBaseMaterial piston;

    public LegacyPiston(PistonBaseMaterial piston) {
        super(piston);
        this.piston = piston;
    }

    @Override
    public boolean isExtended() {
        return piston.isPowered();
    }

    @Override
    public void setExtended(boolean extended) {
        piston.setPowered(extended);
    }

    public PistonBaseMaterial toBukkit() {
        return piston;
    }

}
