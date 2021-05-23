package com.jackalantern29.flatx.api.block.data;

import com.jackalantern29.flatx.api.block.FlatContainer;
import com.jackalantern29.flatx.api.inventory.FlatInventory;

public interface FlatChest extends FlatContainer {
    FlatInventory getBlockInventory();
}
