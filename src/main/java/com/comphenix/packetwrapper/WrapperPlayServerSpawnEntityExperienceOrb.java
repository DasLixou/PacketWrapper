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

public class WrapperPlayServerSpawnEntityExperienceOrb extends AbstractPacket {
	public static final PacketType TYPE =
			PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB;

	public WrapperPlayServerSpawnEntityExperienceOrb() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerSpawnEntityExperienceOrb(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve Entity ID.
	 * <p>
	 * Notes: entity's ID
	 * 
	 * @return The current Entity ID
	 */
	public int getEntityID() {
		return handle.getIntegers().read(0);
	}

	/**
	 * Set Entity ID.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerSpawnEntityExperienceOrb setEntityID(int value) {
		handle.getIntegers().write(0, value);
		return this;
	}

	/**
	 * Retrieve the entity of the painting that will be spawned.
	 * 
	 * @param world - the current world of the entity.
	 * @return The spawned entity.
	 */
	public Entity getEntity(World world) {
		return handle.getEntityModifier(world).read(0);
	}

	/**
	 * Retrieve the entity of the painting that will be spawned.
	 * 
	 * @param event - the packet event.
	 * @return The spawned entity.
	 */
	public Entity getEntity(PacketEvent event) {
		return getEntity(event.getPlayer().getWorld());
	}

	/**
	 * Retrieve the x position of the object.
	 * <p>
	 * Note that the coordinate is rounded off to the nearest 1/32 of a meter.
	 * 
	 * @return The current X
	 */
	public double getX() {
		return handle.getDoubles().read(0);
	}

	/**
	 * Set the x position of the object.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerSpawnEntityExperienceOrb setX(double value) {
		handle.getDoubles().write(0, value);
		return this;
	}

	/**
	 * Retrieve the y position of the object.
	 * <p>
	 * Note that the coordinate is rounded off to the nearest 1/32 of a meter.
	 * 
	 * @return The current y
	 */
	public double getY() {
		return handle.getDoubles().read(1);
	}

	/**
	 * Set the y position of the object.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerSpawnEntityExperienceOrb setY(double value) {
		handle.getDoubles().write(1, value);
		return this;
	}

	/**
	 * Retrieve the z position of the object.
	 * <p>
	 * Note that the coordinate is rounded off to the nearest 1/32 of a meter.
	 * 
	 * @return The current z
	 */
	public double getZ() {
		return handle.getDoubles().read(2);
	}

	/**
	 * Set the z position of the object.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerSpawnEntityExperienceOrb setZ(double value) {
		handle.getDoubles().write(2, value);
		return this;
	}

	/**
	 * Sets X, Y and Z from your location
	 * @param location Your input
	 * @return
	 */
	public WrapperPlayServerSpawnEntityExperienceOrb fromLocation(Location location) {
		setX(location.getX());
		setY(location.getY());
		setZ(location.getZ());
		return this;
	}

	/**
	 * Updates X, Y and Z of your input and returns it.
	 * @param location old location, which gets updated.
	 * @return
	 */
	public Location updateLocation(Location location) {
		location.setX(getX());
		location.setY(getY());
		location.setZ(getZ());
		return location;
	}

	/**
	 * Retrieve Count.
	 * <p>
	 * Notes: the amount of experience this orb will reward once collected
	 * 
	 * @return The current Count
	 */
	public int getCount() {
		return handle.getIntegers().read(1);
	}

	/**
	 * Set Count.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerSpawnEntityExperienceOrb setCount(int value) {
		handle.getIntegers().write(1, value);
		return this;
	}
}
