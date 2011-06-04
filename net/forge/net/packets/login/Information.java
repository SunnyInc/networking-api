package net.forge.net.packets.login;

import net.forge.io.StreamBuffer;
import net.forge.net.Passport;
import net.forge.net.exceptions.InvalidPacketException;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.packets.LoginPacket;
import org.jboss.netty.channel.Channel;

/**
 * RuneForge | 317
 * PlayerInformation.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Information extends LoginPacket {
    
    @Override
    public void validate(Passport passport) throws InvalidPacketException {
        
    }

    @Override
    public void applyUpdate(Passport passport) {
        
    }

    @Override
    public void parse(StreamBuffer buffer) throws MalformedPacketException {
        try {
            int packetsize = (buffer.getByteBuffer().get() & 0xFF);
            int encryptsize = packetsize - (36 + 1 + 1 + 2);
            int validatestart = (buffer.getByteBuffer().get() & 0xFF);
            int revision = (buffer.getByteBuffer().getShort() & 0xFFFF);
        } catch(Exception ex) {
            throw new MalformedPacketException(ex.getMessage());
        }
    }

    @Override
    public void writeResponse(Passport passport, Channel channel) {
        
    }
}
