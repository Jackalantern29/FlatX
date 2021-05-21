package com.jackalantern29.flatx.api;

import com.jackalantern29.flatx.api.enums.FlatMaterial;

import java.util.Set;

public interface FlatPlayer {
    <T> void spawnParticle(T particle, FlatLocation location, int count);
    <T> void spawnParticle(T particle, double x, double y, double z, int count);
    <T> void spawnParticle(T particle, FlatLocation location, int count, T data);
    <T> void spawnParticle(T particle, double x, double y, double z, int count, T data);
    <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ);
    <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ);
    <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, T data);
    <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data);
    <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, int extra);
    <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, int extra);
    <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, int extra, T data);
    <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, int extra, T data);
    <T> void spawnParticle(T particle, FlatLocation location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force);
    <T> void spawnParticle(T particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data, boolean force);
    FlatBlock getTargetBlock(Set<FlatMaterial> transparent, int maxDistance);
}
