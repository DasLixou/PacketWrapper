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

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerMount extends AbstractPacket {

	public static final PacketType TYPE = PacketType.Play.Server.MOUNT;

	public WrapperPlayServerMount() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerMount(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve Entity ID.
	 * <p>
	 * Notes: vehicle's EID
	 * 
	 * @return The current Entity ID
	 */
	public int getEntityID() {
		return handle.getIntegers().read(0);
	}

	/**
	 * Retrieve the entity involved in this event.
	 * 
	 * @param world - the current world of the entity.
	 * @return The involved entity.
	 */
	public Entity getEntity(World world) {
		return handle.getEntityModifier(world).read(0);
	}

	/**
	 * Retrieve the entity involved in this event.
	 * 
	 * @param event - the packet event.
	 * @return The involved entity.
	 */
	public Entity getEntity(PacketEvent event) {
		return getEntity(event.getPlayer().getWorld());
	}

	/**
	 * Set Entity ID.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerMount setEntityID(int value) {
		handle.getIntegers().write(0, value);
		return this;
	}

	public int[] getPassengerIds() {
		return handle.getIntegerArrays().read(0);
	}

	public WrapperPlayServerMount setPassengerIds(int[] value) {
		handle.getIntegerArrays().write(0, value);
		return this;
	}

	public List<Entity> getPassengers(PacketEvent event) {
		return getPassengers(event.getPlayer().getWorld());
	}

	public List<Entity> getPassengers(World world) {
		int[] ids = getPassengerIds();
		List<Entity> passengers = new ArrayList<>();
		ProtocolManager manager = ProtocolLibrary.getProtocolManager();

		for (int id : ids) {
			Entity entity = manager.getEntityFromID(world, id);
			if (entity != null) {
				passengers.add(entity);
			}
		}

		return passengers;
	}

	public WrapperPlayServerMount setPassengers(List<Entity> value) {
		int[] array = new int[value.size()];
		for (int i = 0; i < value.size(); i++) {
			array[i] = value.get(i).getEntityId();
		}

		setPassengerIds(array);
		return this;
	}
}
