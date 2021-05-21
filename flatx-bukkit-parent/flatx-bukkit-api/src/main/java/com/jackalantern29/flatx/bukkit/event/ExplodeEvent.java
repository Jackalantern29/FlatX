package com.jackalantern29.flatx.bukkit.event;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class ExplodeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final Object source;
    private final Location location;
    private final List<Block> blocks;
    private float yield;

    public ExplodeEvent(Object source, Location location, List<Block> blocks, float yield) {
        this.source = source;
        this.location = location;
        this.blocks = blocks;
        this.yield = yield;
        this.cancel = false;
    }

    public Object getSource() {
        return source;
    }

    public Location getLocation() {
        return location;
    }

    public List<Block> blockList() {
        return blocks;
    }

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
