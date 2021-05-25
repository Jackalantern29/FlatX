package com.jackalantern29.flatx.craftbukkit.legacy.block;

import com.jackalantern29.flatx.api.block.FlatContainer;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockState;
import com.jackalantern29.flatx.craftbukkit.legacy.inventory.LegacyInventory;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.InventoryHolder;

public class LegacyContainer<T extends InventoryHolder & BlockState> extends LegacyBlockState implements FlatContainer {
    private final T container;

    public LegacyContainer(T container) {
        super(container);
        this.container = container;
    }

    public T toBukkit() {
        return container;
    }

    @Override
    public FlatInventory getInventory() {
        return new LegacyInventory(container.getInventory());
    }

    @Override
    public FlatInventory getSnapshotInventory() {
        return new LegacyInventory(container.getInventory());
    }
}
