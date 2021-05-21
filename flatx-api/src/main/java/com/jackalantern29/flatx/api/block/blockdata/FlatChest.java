package com.jackalantern29.flatx.api.block.blockdata;

import com.jackalantern29.flatx.api.block.FlatContainer;
import com.jackalantern29.flatx.api.inventory.FlatInventory;

public interface FlatChest extends FlatContainer {
    FlatInventory getBlockInventory();
}
