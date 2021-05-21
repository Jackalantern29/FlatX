package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import com.jackalantern29.flatx.bukkit.craftbukkit.flatten.FlattenBukkitAdapter;
import com.jackalantern29.flatx.bukkit.craftbukkit.legacy.LegacyBukkitAdapter;
import com.jackalantern29.flatx.bukkit.listener.ExplodeListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlatBukkit {
    private final Plugin plugin;
    private boolean register = false;
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
            if(VersionUtil.isFlatVersion()) {
                BukkitAdapter.adapter = new FlattenBukkitAdapter();
            } else {
                BukkitAdapter.adapter = new LegacyBukkitAdapter();
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
        if(flatData instanceof BlockData)
            return BukkitAdapter.adapt((BlockData)flatData);
        else return BukkitAdapter.adapt((MaterialData)flatData);
    }

    public static FlatBlockData createBlockData(String data) {
        if(data == null)
            throw new IllegalArgumentException("Must provide data");
        Object flatData;
        if(VersionUtil.isFlatVersion()) {
            flatData = Bukkit.createBlockData(data);
        } else {
            Material material;
            byte damage;
            Pattern pattern = Pattern.compile("([a-zA-Z]+)\\[?(\\d+)?\\]?");
            Matcher matcher = pattern.matcher(data);
            material = Material.valueOf(matcher.group(1));
            damage = Byte.parseByte(matcher.group(2));
            flatData = new MaterialData(material, damage);
        }
        if(flatData instanceof BlockData)
            return BukkitAdapter.adapt((BlockData)flatData);
        else return BukkitAdapter.adapt((MaterialData)flatData);
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
        if(flatData instanceof BlockData)
            return BukkitAdapter.adapt((BlockData)flatData);
        else return BukkitAdapter.adapt((MaterialData)flatData);
    }
}
