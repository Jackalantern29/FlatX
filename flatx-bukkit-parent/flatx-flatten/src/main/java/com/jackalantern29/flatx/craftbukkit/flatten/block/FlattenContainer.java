package com.jackalantern29.flatx.craftbukkit.flatten.block;

import com.jackalantern29.flatx.api.block.FlatContainer;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockState;
import com.jackalantern29.flatx.craftbukkit.flatten.inventory.FlattenInventory;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.InventoryHolder;

public class FlattenContainer<T extends InventoryHolder & BlockState> extends FlattenBlockState implements FlatContainer {
    private final T container;

    public FlattenContainer(T container) {
        super(container);
        this.container = container;
    }

    public T toBukkit() {
        return container;
    }

    @Override
    public FlatInventory getInventory() {
        return new FlattenInventory(container.getInventory());
    }

    @Override
    public FlatInventory getSnapshotInventory() {
        return new FlattenInventory(container.getInventory());
    }
}