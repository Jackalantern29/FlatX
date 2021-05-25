package com.jackalantern29.flatx.craftbukkit.flatten.block.data.type;

import com.jackalantern29.flatx.api.block.data.type.FlatBed;
import com.jackalantern29.flatx.craftbukkit.flatten.block.data.FlattenDirectional;
import org.bukkit.block.data.type.Bed;

public class FlattenBed extends FlattenDirectional implements FlatBed {
    private final Bed bed;

    public FlattenBed(Bed data) {
        super(data);
        this.bed = data;
    }

    @Override
    public Part getPart() {
        return Part.valueOf(bed.getPart().name());
    }

    @Override
    public boolean isOccupied() {
        return bed.isOccupied();
    }

    @Override
    public void setPart(Part part) {
        bed.setPart(Bed.Part.valueOf(part.name()));
    }

    public Bed toBukkit() {
        return bed;
    }
}
