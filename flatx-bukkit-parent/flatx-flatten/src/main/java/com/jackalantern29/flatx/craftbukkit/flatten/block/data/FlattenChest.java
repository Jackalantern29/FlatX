package com.jackalantern29.flatx.craftbukkit.flatten.block.data;

import com.jackalantern29.flatx.api.block.data.FlatChest;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.craftbukkit.flatten.block.FlattenContainer;
import com.jackalantern29.flatx.craftbukkit.flatten.inventory.FlattenInventory;
import org.bukkit.block.Chest;

public class FlattenChest extends FlattenContainer implements FlatChest {
    private final Chest chest;

    public FlattenChest(Chest chest) {
        super(chest);
        this.chest = chest;
    }

    @Override
    public FlatInventory getBlockInventory() {
        return new FlattenInventory(chest.getBlockInventory());
    }

    public Chest toBukkit() {
        return chest;
    }
}
