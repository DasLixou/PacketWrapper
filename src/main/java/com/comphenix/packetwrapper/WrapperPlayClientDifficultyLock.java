/**
 * This file is part of PacketWrapper.
 * Copyright (C) 2012-2015 Kristian S. Strangeland
 * Copyright (C) 2015 dmulloy2
 *
 * PacketWrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PacketWrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with PacketWrapper.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientDifficultyLock extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.DIFFICULTY_LOCK;
    
    public WrapperPlayClientDifficultyLock() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayClientDifficultyLock(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve Locked.
     * @return The current Locked
     */
    public boolean getLocked() {
        return handle.getBooleans().read(0);
    }
    
    /**
     * Set Locked.
     * @param value - new value.
     */
    public WrapperPlayClientDifficultyLock setLocked(boolean value) {
        handle.getBooleans().write(0, value);
        return this;
    }
    
}
