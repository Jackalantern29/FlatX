package com.jackalantern29.flatx.craftbukkit.legacy;

import com.jackalantern29.flatx.api.FlatBlock;
import com.jackalantern29.flatx.api.FlatPlayer;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.BukkitAdapter;
import com.jackalantern29.flatx.bukkit.IBukkitAdapter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public abstract class LegacyPlayer implements FlatPlayer {
    private final Player player;

    public LegacyPlayer(Player player) {
        this.player = player;
    }

    @Override
    public FlatBlock getTargetBlock(Set<FlatMaterial> transparent, int maxDistance) {
        Set<Material> set = null;
        if(transparent != null) {
            set = new HashSet<>();
            for (FlatMaterial flat : transparent)
                set.add(BukkitAdapter.asBukkitMaterial(flat));
        }
        return new LegacyBlock(player.getTargetBlock(set, maxDistance));
    }

    public Player toBukkit() {
        return player;
    }
}
