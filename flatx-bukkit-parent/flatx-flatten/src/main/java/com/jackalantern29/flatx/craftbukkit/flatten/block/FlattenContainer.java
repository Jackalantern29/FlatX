package com.jackalantern29.flatx.craftbukkit.flatten.block;

import com.jackalantern29.flatx.api.block.FlatContainer;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenBlockState;
import com.jackalantern29.flatx.craftbukkit.flatten.inventory.FlattenInventory;
import org.bukkit.block.Container;

public class FlattenContainer extends FlattenBlockState implements FlatContainer {
    private final Container container;

    public FlattenContainer(Container container) {
        super(container);
        this.container = container;
    }

    @Override
    public FlatInventory getInventory() {
        return new FlattenInventory(container.getInventory());
    }

    @Override
    public FlatInventory getSnapshotInventory() {
        return new FlattenInventory(container.getSnapshotInventory());
    }

    public Container toBukkit() {
        return container;
    }
}
