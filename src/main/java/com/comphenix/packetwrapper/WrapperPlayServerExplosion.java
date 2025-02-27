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

import java.util.List;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Location;

public class WrapperPlayServerExplosion extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Server.EXPLOSION;

	public WrapperPlayServerExplosion() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerExplosion(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve X.
	 * 
	 * @return The current X
	 */
	public double getX() {
		return handle.getDoubles().read(0);
	}

	/**
	 * Set X.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerExplosion setX(double value) {
		handle.getDoubles().write(0, value);
		return this;
	}

	/**
	 * Retrieve Y.
	 * 
	 * @return The current Y
	 */
	public double getY() {
		return handle.getDoubles().read(1);
	}

	/**
	 * Set Y.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerExplosion setY(double value) {
		handle.getDoubles().write(1, value);
		return this;
	}

	/**
	 * Retrieve Z.
	 * 
	 * @return The current Z
	 */
	public double getZ() {
		return handle.getDoubles().read(2);
	}

	/**
	 * Set Z.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerExplosion setZ(double value) {
		handle.getDoubles().write(2, value);
		return this;
	}

	/**
	 * Sets X, Y and Z from your location
	 * @param location Your input
	 * @return
	 */
	public WrapperPlayServerExplosion fromLocation(Location location) {
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
	 * Retrieve Radius.
	 * <p>
	 * Notes: currently unused in the client
	 * 
	 * @return The current Radius
	 */
	public float getRadius() {
		return handle.getFloat().read(0);
	}

	/**
	 * Set Radius.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerExplosion setRadius(float value) {
		handle.getFloat().write(0, value);
		return this;
	}

	/**
	 * Retrieve Record count.
	 * <p>
	 * Notes: this is the count, not the size. The size is 3 times this value.
	 *
	 * @return The current Record count
	 */
	public List<BlockPosition> getRecords() {
		return handle.getBlockPositionCollectionModifier().read(0);
	}

	/**
	 * Retrieve Record count.
	 * <p>
	 * Notes: this is the count, not the size. The size is 3 times this value.
	 * 
	 * @return The current Record count
	 * @deprecated Misspelled.
	 * @see #getRecords()
	 */
	@Deprecated
	public List<BlockPosition> getRecors() {
		return handle.getBlockPositionCollectionModifier().read(0);
	}

	/**
	 * Set Record count.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerExplosion setRecords(List<BlockPosition> value) {
		handle.getBlockPositionCollectionModifier().write(0, value);
		return this;
	}

	public float getPlayerVelocityX() {
		return handle.getFloat().read(1);
	}

	public WrapperPlayServerExplosion setPlayerVelocityX(float value) {
		handle.getFloat().write(1, value);
		return this;
	}

	public float getPlayerVelocityY() {
		return handle.getFloat().read(2);
	}

	public WrapperPlayServerExplosion setPlayerVelocityY(float value) {
		handle.getFloat().write(2, value);
		return this;
	}

	public float getPlayerVelocityZ() {
		return handle.getFloat().read(3);
	}

	public WrapperPlayServerExplosion setPlayerVelocityZ(float value) {
		handle.getFloat().write(3, value);
		return this;
	}

}
