package com.jackalantern29.flatx.craftbukkit.flatten.inventory;

import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.api.inventory.FlatInventoryHolder;
import org.bukkit.inventory.InventoryHolder;

public class FlattenInventoryHolder implements FlatInventoryHolder {
    private final InventoryHolder inventoryHolder;

    public FlattenInventoryHolder(InventoryHolder inventoryHolder) {
        this.inventoryHolder = inventoryHolder;
    }

    @Override
    public FlatInventory getInventory() {
        return new FlattenInventory(inventoryHolder.getInventory());
    }

    public InventoryHolder toBukkit() {
        return inventoryHolder;
    }
}
