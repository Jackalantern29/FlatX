package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.FlatPlayer;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.craftbukkit.flatten.FlattenBukkitAdapter;
import com.jackalantern29.flatx.bukkit.craftbukkit.legacy.LegacyBukkitAdapter;
import com.jackalantern29.flatx.bukkit.listener.ExplodeListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlatBukkit {
    private final Plugin plugin;
    private boolean register = false;
    private static Set<FlatBukkitPlayer> players = new HashSet<>();
    private Set<Listener> listenerSet = new HashSet<Listener>() {{
        add(new ExplodeListener());
        add(new ExplodeListener.EntityExplodeListener());
        if(VersionUtil.getBukkitVersionID() > 1)
            add(new ExplodeListener.BlockExplodeListener());
    }};

    public FlatBukkit(Plugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        if(!register) {
            for(Listener listener : listenerSet)
                Bukkit.getPluginManager().registerEvents(listener, plugin);
            Bukkit.getPluginManager().registerEvents(new Listener() {
                @EventHandler(ignoreCancelled = true)
                public void playerJoin(PlayerJoinEvent event) {
                    switch(VersionUtil.getBukkitVersionID()) {
                        case 1:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_8_R1.XPlayer(event.getPlayer()));
                            break;
                        case 2:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_8_R2.XPlayer(event.getPlayer()));
                            break;
                        case 3:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_8_R3.XPlayer(event.getPlayer()));
                            break;
                        case 4:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_9_R1.XPlayer(event.getPlayer()));
                            break;
                        case 5:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_9_R2.XPlayer(event.getPlayer()));
                            break;
                        case 6:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_10_R1.XPlayer(event.getPlayer()));
                            break;
                        case 7:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_11_R1.XPlayer(event.getPlayer()));
                            break;
                        case 8:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_12_R1.XPlayer(event.getPlayer()));
                            break;
                        case 9:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_13_R1.XPlayer(event.getPlayer()));
                            break;
                        case 10:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_13_R2.XPlayer(event.getPlayer()));
                            break;
                        case 11:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_14_R1.XPlayer(event.getPlayer()));
                            break;
                        case 12:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_15_R1.XPlayer(event.getPlayer()));
                            break;
                        case 13:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_16_R1.XPlayer(event.getPlayer()));
                            break;
                        case 14:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_16_R2.XPlayer(event.getPlayer()));
                            break;
                        case 15:
                            players.add(new com.jackalantern29.flatx.craftbukkit.v1_16_R3.XPlayer(event.getPlayer()));
                            break;
                    }
                }
                @EventHandler
                public void playerLeave(PlayerQuitEvent event) {
                    for(FlatPlayer player : new HashSet<>(players))
                        if(player.getUniqueId().equals(event.getPlayer().getUniqueId()))
                            players.remove(player);
                }
            }, plugin);
            if(VersionUtil.isFlatVersion()) {
                BukkitAdapter.adapter = new FlattenBukkitAdapter(plugin);
            } else {
                BukkitAdapter.adapter = new LegacyBukkitAdapter();
            }
            
            for(Player player : Bukkit.getOnlinePlayers()) {
                switch(VersionUtil.getBukkitVersionID()) {
                    case 1:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_8_R1.XPlayer(player));
                        break;
                    case 2:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_8_R2.XPlayer(player));
                        break;
                    case 3:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_8_R3.XPlayer(player));
                        break;
                    case 4:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_9_R1.XPlayer(player));
                        break;
                    case 5:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_9_R2.XPlayer(player));
                        break;
                    case 6:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_10_R1.XPlayer(player));
                        break;
                    case 7:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_11_R1.XPlayer(player));
                        break;
                    case 8:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_12_R1.XPlayer(player));
                        break;
                    case 9:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_13_R1.XPlayer(player));
                        break;
                    case 10:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_13_R2.XPlayer(player));
                        break;
                    case 11:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_14_R1.XPlayer(player));
                        break;
                    case 12:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_15_R1.XPlayer(player));
                        break;
                    case 13:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_16_R1.XPlayer(player));
                        break;
                    case 14:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_16_R2.XPlayer(player));
                        break;
                    case 15:
                        players.add(new com.jackalantern29.flatx.craftbukkit.v1_16_R3.XPlayer(player));
                        break;
                }
            }
            register = true;
        }
    }

    public void unregister() {
        if(register) {
            for(Listener listener : listenerSet)
                HandlerList.unregisterAll(listener);
            BukkitAdapter.adapter = null;
            register = false;
        }
    }

    public boolean isRegister() {
        return register;
    }

    public static IBukkitAdapter getAdapter() {
        return BukkitAdapter.adapter;
    }

    public static FlatBlockData createBlockData(FlatMaterial material) {
        if(material == null)
            throw new IllegalArgumentException("Must provide material");
        Object flatData;
        if(VersionUtil.isFlatVersion()) {
            flatData = Bukkit.createBlockData(BukkitAdapter.asBukkitMaterial(material));
        } else {
            flatData = new MaterialData(BukkitAdapter.asBukkitMaterial(material));
        }
        if(flatData instanceof MaterialData)
            return BukkitAdapter.adapt((MaterialData)flatData);
        else return BukkitAdapter.adapt((BlockData)flatData);
    }

    public static FlatBlockData createBlockData(String data) {
        if(data == null)
            throw new IllegalArgumentException("Must provide data");
        Object flatData = null;
        if(VersionUtil.isFlatVersion()) {
            flatData = Bukkit.createBlockData(data);
        } else {
            Material material;
            byte damage;
            Pattern pattern = Pattern.compile("([a-zA-Z]+)\\[?(\\d+)?\\]?");
            Matcher matcher = pattern.matcher(data);
            if(matcher.find()) {
                material = Material.valueOf(matcher.group(1).toUpperCase());
                if(matcher.group(2) == null)
                    damage = (byte)0;
                else
                    damage = Byte.parseByte(matcher.group(2));
                flatData = new MaterialData(material, damage);
            }
        }
        if(flatData instanceof MaterialData)
            return BukkitAdapter.adapt((MaterialData)flatData);
        else return BukkitAdapter.adapt((BlockData)flatData);
    }

    public static FlatBlockData createBlockData(FlatMaterial material, String data) {
        if(material == null || data == null)
            throw new IllegalArgumentException("Must provide one of material or data");
        Object flatData;
        if(VersionUtil.isFlatVersion()) {
            flatData = Bukkit.createBlockData(BukkitAdapter.asBukkitMaterial(material), data);
        } else {
            flatData = new MaterialData(BukkitAdapter.asBukkitMaterial(material), (byte)0);
        }
        if(flatData instanceof MaterialData)
            return BukkitAdapter.adapt((MaterialData)flatData);
        else return BukkitAdapter.adapt((BlockData)flatData);
    }

    public static FlatBukkitPlayer getPlayer(String name) {
        for(FlatBukkitPlayer player : players) {
            if(player.getName().equalsIgnoreCase(name))
                return player;
        }
        return null;
    }

    public static FlatBukkitPlayer getPlayer(UUID uuid) {
        for(FlatBukkitPlayer player : players) {
            if(player.getUniqueId().equals(uuid))
                return player;
        }
        return null;
    }

    public static Collection<FlatBukkitPlayer> getPlayers() {
        return players;
    }

    public static FloatingText createFloatingText(String text, Location location) {
        switch(VersionUtil.getBukkitVersionID()) {
            case 1: return new com.jackalantern29.flatx.craftbukkit.v1_8_R1.XFloatingText(text, location);
            case 2: return new com.jackalantern29.flatx.craftbukkit.v1_8_R2.XFloatingText(text, location);
            case 3: return new com.jackalantern29.flatx.craftbukkit.v1_8_R3.XFloatingText(text, location);
            case 4: return new com.jackalantern29.flatx.craftbukkit.v1_9_R1.XFloatingText(text, location);
            case 5: return new com.jackalantern29.flatx.craftbukkit.v1_9_R2.XFloatingText(text, location);
            case 6: return new com.jackalantern29.flatx.craftbukkit.v1_10_R1.XFloatingText(text, location);
            case 7: return new com.jackalantern29.flatx.craftbukkit.v1_11_R1.XFloatingText(text, location);
            case 8: return new com.jackalantern29.flatx.craftbukkit.v1_12_R1.XFloatingText(text, location);
            case 9: return new com.jackalantern29.flatx.craftbukkit.v1_13_R1.XFloatingText(text, location);
            case 10: return new com.jackalantern29.flatx.craftbukkit.v1_13_R2.XFloatingText(text, location);
            case 11: return new com.jackalantern29.flatx.craftbukkit.v1_14_R1.XFloatingText(text, location);
            case 12: return new com.jackalantern29.flatx.craftbukkit.v1_15_R1.XFloatingText(text, location);
            case 13: return new com.jackalantern29.flatx.craftbukkit.v1_16_R1.XFloatingText(text, location);
            case 14: return new com.jackalantern29.flatx.craftbukkit.v1_16_R2.XFloatingText(text, location);
            case 15: return new com.jackalantern29.flatx.craftbukkit.v1_16_R3.XFloatingText(text, location);
            default: return null;
        }
    }
}
