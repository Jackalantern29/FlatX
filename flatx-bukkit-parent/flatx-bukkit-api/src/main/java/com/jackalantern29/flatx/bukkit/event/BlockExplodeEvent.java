package com.jackalantern29.flatx.bukkit.event;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.HandlerList;

import java.util.List;

public class BlockExplodeEvent extends ExplodeEvent {
    private static final HandlerList handlers = new HandlerList();

    public BlockExplodeEvent(Block source, Location location, List<Block> blocks, float yield) {
        super(source, location, blocks, yield);
    }

    public Block getBlock() {
        return (Block)getSource();
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
