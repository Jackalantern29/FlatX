package com.jackalantern29.flatx.api;

public class FlatLocation {
    private FlatWorld world;
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;

    public FlatLocation(FlatWorld world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public FlatLocation(FlatWorld world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public FlatWorld getWorld() {
        return world;
    }

    public void setWorld(FlatWorld world) {
        this.world = world;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }
}
