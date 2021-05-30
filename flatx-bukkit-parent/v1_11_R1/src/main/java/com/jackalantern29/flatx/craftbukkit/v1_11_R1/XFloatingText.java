package com.jackalantern29.flatx.craftbukkit.v1_11_R1;

import com.jackalantern29.flatx.bukkit.FloatingText;
import net.minecraft.server.v1_11_R1.MathHelper;
import net.minecraft.server.v1_11_R1.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_11_R1.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_11_R1.PacketPlayOutSpawnEntityLiving;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class XFloatingText implements FloatingText {
    private HashMap<Player, CraftArmorStand> map = new HashMap<>();
    private Location location;
    private String text;
    public XFloatingText(String text, Location location) {
        this.text = text;
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        for(Map.Entry<Player, CraftArmorStand> entry : map.entrySet()) {
            CraftArmorStand armorStand = entry.getValue();
            CraftPlayer craftPlayer = (CraftPlayer)entry.getKey();
            armorStand.setCustomName(text.replace("&", "§"));
            PacketPlayOutEntityMetadata packetData = new PacketPlayOutEntityMetadata(armorStand.getEntityId(), armorStand.getHandle().getDataWatcher(), false);
            craftPlayer.getHandle().playerConnection.sendPacket(packetData);
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
/*        this.location = location;
        armorStand.world = ((CraftWorld)location.getWorld()).getHandle();
        armorStand.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        PacketPlayOutEntityTeleport packetTeleport = new PacketPlayOutEntityTeleport(armorStand);
        player.getHandle().playerConnection.sendPacket(packetTeleport);*/
    }

    public void addPlayer(Player player) {
        if(!map.containsKey(player)) {
            CraftArmorStand armorStand = (CraftArmorStand) ((CraftWorld)location.getWorld()).createEntity(location, ArmorStand.class).getBukkitEntity();
            CraftPlayer craftPlayer = (CraftPlayer) player;
            armorStand.setCustomName(text.replace("&", "§"));
            armorStand.setCustomNameVisible(true);
            armorStand.setVisible(false);
            armorStand.setSmall(true);
            armorStand.setGravity(false);
            armorStand.setCollidable(false);
            armorStand.setMarker(true);

            ((CraftWorld)location.getWorld()).getHandle().getChunkAt(MathHelper.floor(armorStand.getHandle().locX / 16.0D), MathHelper.floor(armorStand.getHandle().locZ / 16.0D)).a(armorStand.getHandle());
            PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(armorStand.getHandle());
            PacketPlayOutEntityMetadata packetData = new PacketPlayOutEntityMetadata(armorStand.getEntityId(), armorStand.getHandle().getDataWatcher(), false);
            craftPlayer.getHandle().playerConnection.sendPacket(packet);
            craftPlayer.getHandle().playerConnection.sendPacket(packetData);
            map.put(player, armorStand);
        }
    }

    public void removePlayer(Player player) {
        if(map.containsKey(player)) {
            CraftArmorStand armorStand = map.get(player);
            ((CraftWorld)location.getWorld()).getHandle().getChunkAt(MathHelper.floor(armorStand.getHandle().locX / 16.0D), MathHelper.floor(armorStand.getHandle().locZ / 16.0D)).b(armorStand.getHandle());
            PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(armorStand.getEntityId());
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(destroy);
            map.remove(player);
        }
    }

    public Collection<Player> getPlayers() {
        return map.keySet();
    }

    public void remove() {
        for(CraftArmorStand armorStand : map.values()) {
            ((CraftWorld)location.getWorld()).getHandle().getChunkAt(MathHelper.floor(armorStand.getHandle().locX / 16.0D), MathHelper.floor(armorStand.getHandle().locZ / 16.0D)).b(armorStand.getHandle());
        }
        for(Player player : new HashSet<>(getPlayers()))
            removePlayer(player);
        map.clear();
    }
}
