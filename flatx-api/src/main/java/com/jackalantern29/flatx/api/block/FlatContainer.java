package com.jackalantern29.flatx.api.block;

import com.jackalantern29.flatx.api.FlatBlockState;
import com.jackalantern29.flatx.api.inventory.FlatInventory;
import com.jackalantern29.flatx.api.inventory.FlatInventoryHolder;

public interface FlatContainer extends FlatBlockState, FlatInventoryHolder {
    FlatInventory getInventory();
    FlatInventory getSnapshotInventory();
}
