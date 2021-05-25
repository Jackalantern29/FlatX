package com.jackalantern29.flatx.craftbukkit.legacy.block.data.type;

import com.jackalantern29.flatx.api.block.data.type.FlatBed;
import com.jackalantern29.flatx.craftbukkit.legacy.block.data.LegacyDirectional;
import org.bukkit.material.Bed;

public class LegacyBed extends LegacyDirectional implements FlatBed {
    private final Bed bed;

    public LegacyBed(Bed data) {
        super(data);
        this.bed = data;
    }

    @Override
    public Part getPart() {
        if(bed.isHeadOfBed())
            return Part.HEAD;
        else
            return Part.FOOT;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public void setPart(Part part) {
        bed.setHeadOfBed(part == Part.HEAD);
    }

    public Bed toBukkit() {
        return bed;
    }
}
