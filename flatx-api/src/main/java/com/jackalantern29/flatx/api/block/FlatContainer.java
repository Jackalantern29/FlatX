package com.jackalantern29.flatx.api.block;

import com.jackalantern29.flatx.api.FlatBlockState;
import com.jackalantern29.flatx.api.inventory.FlatInventory;

public interface FlatContainer extends FlatBlockState {
    FlatInventory getInventory();
    FlatInventory getSnapshotInventory();
}
