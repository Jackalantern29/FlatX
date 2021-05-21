package com.jackalantern29.flatx.bukkit.event;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;

import java.util.List;

public class EntityExplodeEvent extends ExplodeEvent {
    private static final HandlerList handlers = new HandlerList();

    public EntityExplodeEvent(Entity source, Location location, List<Block> blocks, float yield) {
        super(source, location, blocks, yield);
    }

    public Entity getEntity() {
        return (Entity)getSource();
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
