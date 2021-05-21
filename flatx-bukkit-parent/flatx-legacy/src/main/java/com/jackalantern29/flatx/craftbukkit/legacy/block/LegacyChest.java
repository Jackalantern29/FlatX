package com.jackalantern29.flatx.craftbukkit.legacy.block;

import com.jackalantern29.flatx.api.block.blockdata.FlatChest;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.craftbukkit.legacy.inventory.LegacyInventory;
import org.bukkit.block.Chest;

public class LegacyChest extends LegacyContainer implements FlatChest {
    private final Chest chest;

    public LegacyChest(Chest chest) {
        super(chest);
        this.chest = chest;
    }

    @Override
    public FlatInventory getBlockInventory() {
        return new LegacyInventory(chest.getBlockInventory());
    }

    public Chest toBukkit() {
        return chest;
    }
}
