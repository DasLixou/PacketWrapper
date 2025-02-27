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

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;

public class WrapperPlayServerSpawnEntityPainting extends AbstractPacket {
	public static final PacketType TYPE =
			PacketType.Play.Server.SPAWN_ENTITY_PAINTING;

	public WrapperPlayServerSpawnEntityPainting() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerSpawnEntityPainting(PacketContainer packet) {
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
	public WrapperPlayServerSpawnEntityPainting setEntityID(int value) {
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
	 * Retrieve Location.
	 * <p>
	 * Notes: center coordinates
	 * 
	 * @return The current Location
	 */
	public BlockPosition getLocation() {
		return handle.getBlockPositionModifier().read(0);
	}

	/**
	 * Set Location.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerSpawnEntityPainting setLocation(BlockPosition value) {
		handle.getBlockPositionModifier().write(0, value);
		return this;
	}

	public Direction getDirection() {
		return handle.getDirections().read(0);
	}

	public WrapperPlayServerSpawnEntityPainting setDirection(Direction value) {
		handle.getDirections().write(0, value);
		return this;
	}

	public int getPaintingId() {
		return handle.getIntegers().read(0);
	}

	public WrapperPlayServerSpawnEntityPainting setPaintingId(int value) {
		handle.getIntegers().write(0, value);
		return this;
	}
}
