package com.jackalantern29.flatx.craftbukkit.v1_11_R1;

import com.jackalantern29.flatx.api.FlatLocation;
import com.jackalantern29.flatx.api.FlatWorld;
import com.jackalantern29.flatx.craftbukkit.legacy.LegacyWorld;
import net.minecraft.server.v1_11_R1.EnumParticle;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.CraftParticle;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;

public class XWorld extends LegacyWorld {
    public XWorld(World world) {
        super(world);
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
        EnumParticle enumParticle;
        if(particle instanceof EnumParticle)
            enumParticle = (EnumParticle)particle;
        else if(particle instanceof Particle)
            enumParticle = CraftParticle.toNMS((Particle)particle);
        else
            enumParticle = EnumParticle.valueOf(particle.toString().toUpperCase());
        spawnParticle(enumParticle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force);
    }

    public <T> void spawnParticle(EnumParticle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        spawnParticle(CraftParticle.toBukkit(particle), x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force);
    }
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force) {
        CraftWorld world = (CraftWorld)toBukkit();
        world.getHandle().sendParticles(
                null,
                CraftParticle.toNMS(particle),
                force,
                x, y, z,
                count,
                offsetX, offsetY, offsetZ,
                extra,
                CraftParticle.toData(particle, data));
    }
}
