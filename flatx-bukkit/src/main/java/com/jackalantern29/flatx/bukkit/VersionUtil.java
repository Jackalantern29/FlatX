package com.jackalantern29.flatx.bukkit;

import org.bukkit.Bukkit;

public class VersionUtil {
    public static final String NMS_VERSION = Bukkit.getServer().getClass().getPackage().getName().substring(23);

    public static String getNmsVersion() {
        return NMS_VERSION;
    }

    public static int getBukkitVersionID() {
        if(getNmsVersion() == null)
            return -1;
        switch(getNmsVersion()) {
            case "v1_8_R1": return 1;
            case "v1_8_R2": return 2;
            case "v1_8_R3": return 3;
            case "v1_9_R1": return 4;
            case "v1_9_R2": return 5;
            case "v1_10_R1": return 6;
            case "v1_11_R1": return 7;
            case "v1_12_R1": return 8;
            case "v1_13_R1": return 9;
            case "v1_13_R2": return 10;
            case "v1_14_R1": return 11;
            case "v1_15_R1": return 12;
            case "v1_16_R1": return 13;
            case "v1_16_R2": return 14;
            case "v1_16_R3": return 15;
        }
        return 999;
    }

    public static boolean isFlatVersion() {
        return getBukkitVersionID() > 8;
    }
}
