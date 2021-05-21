package com.jackalantern29.flatx.craftbukkit.v1_15_R1;

import com.jackalantern29.flatx.api.FlatLocation;
import com.jackalantern29.flatx.craftbukkit.flatten.FlattenPlayer;
import net.minecraft.server.v1_15_R1.PacketPlayOutWorldParticles;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_15_R1.CraftParticle;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class XPlayer extends FlattenPlayer {
    public XPlayer(Player player) {
        super(player);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count) {
        spawnParticle(particle, x, y, z, count, null);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count, T data) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count, data);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count, T data) {
        spawnParticle(particle, x, y, z, count, 0, 0, 0, data);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count, offsetX, offsetY, offsetZ);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {
        spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, null);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, T data) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count, offsetX, offsetY, offsetZ, data);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data) {
        spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, 1, data);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, int extra) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count, offsetX, offsetY, offsetZ, extra);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, int extra) {
        spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, null);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, int extra, T data) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count, offsetX, offsetY, offsetZ, extra, data);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, int extra, T data) {
        spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, false);
    }

    @Override
    public <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        spawnParticle(particle, location.getX(), location.getY(), location.getZ(), count, offsetX, offsetY, offsetZ, extra, data, force);
    }

    @Override
    public <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force);
    }

    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        CraftPlayer player = (CraftPlayer)toBukkit();
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(CraftParticle.toNMS(particle, data), force, (float)x, (float)y, (float)z, (float)offsetX, (float)offsetY, (float)offsetZ, (float)extra, count);
        player.getHandle().playerConnection.sendPacket(packet);
    }

}
