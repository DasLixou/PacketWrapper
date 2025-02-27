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

public class WrapperPlayClientAbilities extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Client.ABILITIES;

	public WrapperPlayClientAbilities() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayClientAbilities(PacketContainer packet) {
		super(packet, TYPE);
	}

	public boolean isInvulnerable() {
		return handle.getBooleans().read(0);
	}

	public WrapperPlayClientAbilities setInvulnerable(boolean value) {
		handle.getBooleans().write(0, value);
		return this;
	}

	/**Misspelled.
	 * @see #isInvulnerable()
	 */
	@Deprecated
	public boolean isInvulnurable() {
		return handle.getBooleans().read(0);
	}

	/**Misspelled.
	 * @see #setInvulnerable(boolean)
	 */
	@Deprecated
	public WrapperPlayClientAbilities setInvulnurable(boolean value) {
		handle.getBooleans().write(0, value);
		return this;
	}

	public boolean isFlying() {
		return handle.getBooleans().read(1);
	}

	public WrapperPlayClientAbilities setFlying(boolean value) {
		handle.getBooleans().write(1, value);
		return this;
	}

	public boolean canFly() {
		return handle.getBooleans().read(2);
	}

	public WrapperPlayClientAbilities setCanFly(boolean value) {
		handle.getBooleans().write(2, value);
		return this;
	}

	public boolean canInstantlyBuild() {
		return handle.getBooleans().read(3);
	}

	public WrapperPlayClientAbilities setCanInstantlyBuild(boolean value) {
		handle.getBooleans().write(3, value);
		return this;
	}

	public float getFlyingSpeed() {
		return handle.getFloat().read(0);
	}

	public WrapperPlayClientAbilities setFlyingSpeed(float value) {
		handle.getFloat().write(0, value);
		return this;
	}

	public float getWalkingSpeed() {
		return handle.getFloat().read(1);
	}

	public WrapperPlayClientAbilities setWalkingSpeed(float value) {
		handle.getFloat().write(1, value);
		return this;
	}
}
