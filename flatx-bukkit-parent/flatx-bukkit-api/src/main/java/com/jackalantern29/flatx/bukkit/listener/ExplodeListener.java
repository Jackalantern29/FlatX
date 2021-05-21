package com.jackalantern29.flatx.bukkit.listener;

import com.jackalantern29.flatx.bukkit.VersionUtil;
import com.jackalantern29.flatx.bukkit.event.ExplodeEvent;
import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ExplodeListener implements Listener {
    private static BlockState clickedBlock = null;

    public static class EntityExplodeListener implements Listener {
        @EventHandler
        public void onEntityExplode(EntityExplodeEvent e) {
            ExplodeEvent event;
            if(VersionUtil.getBukkitVersionID() < 2) {
                if(e.getEntity() == null) {
                    event = new com.jackalantern29.flatx.bukkit.event.BlockExplodeEvent(clickedBlock.getBlock(), e.getLocation(), e.blockList(), e.getYield());
                } else {
                    event = new com.jackalantern29.flatx.bukkit.event.EntityExplodeEvent(e.getEntity(), e.getLocation(), e.blockList(), e.getYield());
                }
            } else {
                event = new com.jackalantern29.flatx.bukkit.event.EntityExplodeEvent(e.getEntity(), e.getLocation(), e.blockList(), e.getYield());
            }
            Bukkit.getPluginManager().callEvent(event);
            e.setYield(event.getYield());
            e.setCancelled(event.isCancelled());
        }
    }

    public static class BlockExplodeListener implements Listener {
        @EventHandler
        public void onBlockExplode(BlockExplodeEvent e) {
            ExplodeEvent event = new com.jackalantern29.flatx.bukkit.event.BlockExplodeEvent(clickedBlock.getBlock(), e.getBlock().getLocation(), e.blockList(), e.getYield());
            Bukkit.getPluginManager().callEvent(event);
            e.setYield(event.getYield());
            e.setCancelled(event.isCancelled());
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
            clickedBlock = event.getClickedBlock().getState();
    }
}
