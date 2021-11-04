/**
 * PacketWrapper - ProtocolLib wrappers for Minecraft packets
 * Copyright (C) dmulloy2 <http://dmulloy2.net>
 * Copyright (C) Kristian S. Strangeland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerEntityTeleport extends AbstractPacket {
	public static final PacketType TYPE =
			PacketType.Play.Server.ENTITY_TELEPORT;

	public WrapperPlayServerEntityTeleport() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerEntityTeleport(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve entity ID.
	 * 
	 * @return The current EID
	 */
	public int getEntityID() {
		return handle.getIntegers().read(0);
	}

	/**
	 * Set entity ID.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerEntityTeleport setEntityID(int value) {
		handle.getIntegers().write(0, value);
		return this;
	}

	/**
	 * Retrieve the entity.
	 * 
	 * @param world - the current world of the entity.
	 * @return The entity.
	 */
	public Entity getEntity(World world) {
		return handle.getEntityModifier(world).read(0);
	}

	/**
	 * Retrieve the entity.
	 * 
	 * @param event - the packet event.
	 * @return The entity.
	 */
	public Entity getEntity(PacketEvent event) {
		return getEntity(event.getPlayer().getWorld());
	}

	public double getX() {
		return handle.getDoubles().read(0);
	}

	public WrapperPlayServerEntityTeleport setX(double value) {
		handle.getDoubles().write(0, value);
		return this;
	}

	public double getY() {
		return handle.getDoubles().read(1);
	}

	public WrapperPlayServerEntityTeleport setY(double value) {
		handle.getDoubles().write(1, value);
		return this;
	}

	public double getZ() {
		return handle.getDoubles().read(2);
	}

	public WrapperPlayServerEntityTeleport setZ(double value) {
		handle.getDoubles().write(2, value);
		return this;
	}

	/**
	 * Retrieve the yaw of the current entity.
	 * 
	 * @return The current Yaw
	 */
	public float getYaw() {
		return (handle.getBytes().read(0) * 360.F) / 256.0F;
	}

	/**
	 * Set the yaw of the current entity.
	 * 
	 * @param value - new yaw.
	 */
	public WrapperPlayServerEntityTeleport setYaw(float value) {
		handle.getBytes().write(0, (byte) (value * 256.0F / 360.0F));
		return this;
	}

	/**
	 * Retrieve the pitch of the current entity.
	 * 
	 * @return The current pitch
	 */
	public float getPitch() {
		return (handle.getBytes().read(1) * 360.F) / 256.0F;
	}

	/**
	 * Set the pitch of the current entity.
	 * 
	 * @param value - new pitch.
	 */
	public WrapperPlayServerEntityTeleport setPitch(float value) {
		handle.getBytes().write(1, (byte) (value * 256.0F / 360.0F));
		return this;
	}

	/**
	 * Sets X, Y, Z, Yaw and Pitch from your location
	 * @param location Your input
	 * @return
	 */
	public WrapperPlayServerEntityTeleport fromLocation(Location location) {
		setX(location.getX());
		setY(location.getY());
		setZ(location.getZ());
		setYaw(location.getYaw());
		setPitch(location.getPitch());
		return this;
	}

	/**
	 * Updates X, Y, Z, Yaw and Pitch of your input and returns it.
	 * @param location old location, which gets updated.
	 * @return
	 */
	public Location updateLocation(Location location) {
		location.setX(getX());
		location.setY(getY());
		location.setZ(getZ());
		location.setYaw(getYaw());
		location.setPitch(getPitch());
		return location;
	}

	public boolean getOnGround() {
		return handle.getBooleans().read(0);
	}

	public WrapperPlayServerEntityTeleport setOnGround(boolean value) {
		handle.getBooleans().write(0, value);
		return this;
	}
}
