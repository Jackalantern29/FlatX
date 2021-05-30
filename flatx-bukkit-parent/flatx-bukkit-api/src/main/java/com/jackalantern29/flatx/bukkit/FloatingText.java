package com.jackalantern29.flatx.bukkit;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Collection;

public interface FloatingText extends FloatingDisplay {
    Location getLocation();
    void setLocation(Location location);
    void addPlayer(Player player);
    void removePlayer(Player player);
    Collection<Player> getPlayers();
    void remove();
    String getText();
    void setText(String text);
}
