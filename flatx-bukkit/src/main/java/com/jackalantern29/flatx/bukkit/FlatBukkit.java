package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlatBukkit {

    public static FlatBlockData createBlockData(FlatMaterial material) {
        Object flatData;
        if(VersionUtil.isFlatVersion()) {
            try {
                flatData = Bukkit.class.getMethod("createBlockData", Material.class).invoke(null, BukkitAdapter.asBukkitMaterial(material));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            flatData = new MaterialData(BukkitAdapter.asBukkitMaterial(material));
        }
        return (FlatBlockData) BukkitAdapter.adapt(flatData);
    }

    public static FlatBlockData createBlockData(String data) {
        Object flatData;
        if(VersionUtil.isFlatVersion()) {
            try {
                flatData = Bukkit.class.getMethod("createBlockData", String.class).invoke(null, data);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            Material material;
            byte damage;
            Pattern pattern = Pattern.compile("([a-zA-Z]+)\\[?(\\d+)?\\]?");
            Matcher matcher = pattern.matcher(data);
            material = Material.valueOf(matcher.group(1));
            damage = Byte.parseByte(matcher.group(2));
            flatData = new MaterialData(material, damage);
        }
        return (FlatBlockData) BukkitAdapter.adapt(flatData);
    }

    public static FlatBlockData createBlockData(FlatMaterial material, String data) {
        Object flatData;
        if(VersionUtil.isFlatVersion()) {
            try {
                flatData = Bukkit.class.getMethod("createBlockData", Material.class, String.class).invoke(null, BukkitAdapter.asBukkitMaterial(material), data);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            flatData = new MaterialData(BukkitAdapter.asBukkitMaterial(material), (byte)0);
        }
        return (FlatBlockData) BukkitAdapter.adapt(flatData);
    }
}
