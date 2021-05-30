package com.jackalantern29.flatx.craftbukkit.flatten;

import com.jackalantern29.flatx.api.FlatBlock;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.BukkitAdapter;
import com.jackalantern29.flatx.bukkit.FlatBukkitPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class FlattenPlayer implements FlatBukkitPlayer {
    private final Player player;

    public FlattenPlayer(Player player) {
        this.player = player;
    }

    public Player toBukkit() {
        return player;
    }

    @Override
    public FlatBlock getTargetBlock(Set<FlatMaterial> transparent, int maxDistance) {
        Set<Material> set = null;
        if(transparent != null) {
            set = new HashSet<>();
            for (FlatMaterial flat : transparent)
                set.add(BukkitAdapter.asBukkitMaterial(flat));
        }
        return new FlattenBlock(player.getTargetBlock(set, maxDistance));
    }

    @Override
    public UUID getUniqueId() {
        return player.getUniqueId();
    }

    @Override
    public String getName() {
        return player.getName();
    }

}
