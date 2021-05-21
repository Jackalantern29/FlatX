package com.jackalantern29.flatx.craftbukkit.legacy.block;

import com.jackalantern29.flatx.api.block.FlatContainer;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyBlockState;
import com.jackalantern29.flatx.craftbukkit.legacy.inventory.LegacyInventory;
import org.bukkit.block.Container;

public class LegacyContainer extends LegacyBlockState implements FlatContainer {
    private final Container container;

    public LegacyContainer(Container container) {
        super(container);
        this.container = container;
    }

    @Override
    public FlatInventory getInventory() {
        return new LegacyInventory(container.getInventory());
    }

    @Override
    public FlatInventory getSnapshotInventory() {
        return new LegacyInventory(container.getSnapshotInventory());
    }

    public Container toBukkit() {
        return container;
    }
}
