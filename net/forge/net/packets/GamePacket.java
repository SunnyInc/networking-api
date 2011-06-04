package net.forge.net.packets;

import net.forge.net.SimplePacket;

/**
 * RuneForge | 317
 * GamePacket.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public abstract class GamePacket extends SimplePacket {
    
    /**
     * Executes the packet.
     */
    abstract void execute();
    
}
