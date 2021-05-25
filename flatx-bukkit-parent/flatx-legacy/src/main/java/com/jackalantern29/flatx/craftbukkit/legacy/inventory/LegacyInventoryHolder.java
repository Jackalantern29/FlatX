package com.jackalantern29.flatx.craftbukkit.legacy.inventory;

import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.api.inventory.FlatInventoryHolder;
import org.bukkit.inventory.InventoryHolder;

public class LegacyInventoryHolder implements FlatInventoryHolder {
    private final InventoryHolder inventoryHolder;

    public LegacyInventoryHolder(InventoryHolder inventoryHolder) {
        this.inventoryHolder = inventoryHolder;
    }

    @Override
    public FlatInventory getInventory() {
        return new LegacyInventory(inventoryHolder.getInventory());
    }

    public InventoryHolder toBukkit() {
        return inventoryHolder;
    }
}
