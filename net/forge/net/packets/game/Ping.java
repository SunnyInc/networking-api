package net.forge.net.packets.game;

import net.forge.io.StreamBuffer;
import net.forge.net.Passport;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.packets.GamePacket;

/**
 * RuneForge | 317
 * Ping.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Ping extends GamePacket {

    @Override
    public void execute(Passport passport) {
        /* Nothing to execute */
    }

    
    @Override
    public void parse(StreamBuffer buffer) throws MalformedPacketException {
        /* Nothing to parse */
    }
}
