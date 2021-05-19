package com.jackalantern29.flatx.craftbukkit.legacy;

import com.jackalantern29.flatx.api.FlatBlockData;
import com.jackalantern29.flatx.api.enums.FlatMaterial;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegacyBlockData implements FlatBlockData {
    private final MaterialData data;

    public LegacyBlockData(Material material) {
        this(material, (byte)0);
    }

    public LegacyBlockData(Material material, byte data) {
        this(new MaterialData(material, data));
    }

    public LegacyBlockData(MaterialData data) {
        this.data = data;
    }

    @Override
    public FlatMaterial getMaterial() {
        return FlatMaterial.getMaterial(data.getItemType().name(), true);
    }

    @Override
    public String getAsString() {
        Pattern pattern = Pattern.compile("([a-zA-Z]+)\\(?(\\d+)?\\)?");
        Matcher matcher = pattern.matcher(data.toString());
        return(matcher.group(1) + "[" + matcher.group(2) + "]");
    }

    public MaterialData getData() {
        return data;
    }
}
