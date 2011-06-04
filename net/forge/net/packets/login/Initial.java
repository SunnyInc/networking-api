package net.forge.net.packets.login;

import net.forge.io.StreamBuffer;
import net.forge.net.Passport;
import net.forge.net.exceptions.InvalidPacketException;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.packets.LoginPacket;
import org.jboss.netty.channel.Channel;

/**
 * RuneForge | 317
 * FirstStrike.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Initial extends LoginPacket {

    /**
     * The username hash.
     */
    byte namehash = -1;
    
    @Override
    public void validate(Passport passport) throws InvalidPacketException {
        /* No validations to check */
    }

    /**
     * Sets the username hash on the passport.
     * @param passport The passport to update.
     */
    @Override
    public void applyUpdate(Passport passport) {
        passport.setUsernameHash(namehash);
        passport.generateServerKey();
    }

    /**
     * 
     * @param buffer The stream buffer to parse.
     * @throws MalformedPacketException
     *          -Thrown if the packet is malformed or an exception was thrown
     *          when the packet was being parsed.
     */
    @Override
    public void parse(StreamBuffer buffer) throws MalformedPacketException {
        namehash = buffer.getByteBuffer().get();
    }

    @Override
    public void writeResponse(Passport passport, Channel channel) {
        StreamBuffer buffer = new StreamBuffer();
        buffer.put((byte) 0); /* @see UpdateTypes.txt */
        buffer.put((long) passport.getServerKey());
        channel.write(buffer);
    }
}
