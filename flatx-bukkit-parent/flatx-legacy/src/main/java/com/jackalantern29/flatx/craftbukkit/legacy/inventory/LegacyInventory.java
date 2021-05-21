package com.jackalantern29.flatx.craftbukkit.legacy.inventory;

import com.jackalantern29.flatx.api.inventory.FlatInventory;
import org.bukkit.inventory.Inventory;

public class LegacyInventory implements FlatInventory {
    private final Inventory inventory;

    public LegacyInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory toBukkit() {
        return inventory;
    }
}
