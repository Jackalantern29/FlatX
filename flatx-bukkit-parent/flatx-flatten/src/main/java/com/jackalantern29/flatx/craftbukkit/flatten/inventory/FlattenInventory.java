package com.jackalantern29.flatx.craftbukkit.flatten.inventory;

import com.jackalantern29.flatx.api.inventory.FlatInventory;
import org.bukkit.inventory.Inventory;

public class FlattenInventory implements FlatInventory {
    private final Inventory inventory;

    public FlattenInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory toBukkit() {
        return inventory;
    }
}
