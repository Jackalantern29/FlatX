package com.jackalantern29.flatx.bukkit;

import com.jackalantern29.flatx.api.enums.FlatMaterial;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class BukkitAdapter {
    public static FlatMaterial adapt(Material material) {
        return FlatMaterial.getMaterial(material.name(), !VersionUtil.isFlatVersion());
    }

    public static Material asBukkitMaterial(FlatMaterial material) {
        if(VersionUtil.isFlatVersion())
            return Material.valueOf(material.name());
        else
            return Material.valueOf(material.getLegacyName());
    }

    public static MaterialData asBukkitMaterialData(FlatMaterial material) {
        if(VersionUtil.isFlatVersion())
            return null;
        return new MaterialData(material.getLegacyId(), material.getLegacyData());
    }
}
