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

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.Location;

public class WrapperPlayClientPositionLook extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Client.POSITION_LOOK;

	public WrapperPlayClientPositionLook() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayClientPositionLook(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve X.
	 * <p>
	 * Notes: absolute position
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
	public WrapperPlayClientPositionLook setX(double value) {
		handle.getDoubles().write(0, value);
		return this;
	}

	/**
	 * Retrieve Feet Y.
	 * <p>
	 * Notes: absolute feet position. Is normally HeadY - 1.62. Used to modify
	 * the players bounding box when going up stairs, crouching, etc…
	 * 
	 * @return The current FeetY
	 */
	public double getY() {
		return handle.getDoubles().read(1);
	}

	/**
	 * Set Feet Y.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayClientPositionLook setY(double value) {
		handle.getDoubles().write(1, value);
		return this;
	}

	/**
	 * Retrieve Z.
	 * <p>
	 * Notes: absolute position
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
	public WrapperPlayClientPositionLook setZ(double value) {
		handle.getDoubles().write(2, value);
		return this;
	}

	/**
	 * Retrieve Yaw.
	 * <p>
	 * Notes: absolute rotation on the X Axis, in degrees
	 * 
	 * @return The current Yaw
	 */
	public float getYaw() {
		return handle.getFloat().read(0);
	}

	/**
	 * Set Yaw.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayClientPositionLook setYaw(float value) {
		handle.getFloat().write(0, value);
		return this;
	}

	/**
	 * Retrieve Pitch.
	 * <p>
	 * Notes: absolute rotation on the Y Axis, in degrees
	 * 
	 * @return The current Pitch
	 */
	public float getPitch() {
		return handle.getFloat().read(1);
	}

	/**
	 * Set Pitch.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayClientPositionLook setPitch(float value) {
		handle.getFloat().write(1, value);
		return this;
	}

	/**
	 * Sets X, Y, Z, Yaw and Pitch from your location
	 * @param location Your input
	 * @return
	 */
	public WrapperPlayClientPositionLook fromLocation(Location location) {
		setX(location.getX()).setY(location.getY()).setZ(location.getZ()).setYaw(location.getYaw()).setPitch(location.getPitch());
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

	/**
	 * Retrieve On Ground.
	 * <p>
	 * Notes: true if the client is on the ground, False otherwise
	 * 
	 * @return The current On Ground
	 */
	public boolean getOnGround() {
		return handle.getBooleans().read(0);
	}

	/**
	 * Set On Ground.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayClientPositionLook setOnGround(boolean value) {
		handle.getBooleans().write(0, value);
		return this;
	}

}
