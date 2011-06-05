package net.forge.net.packets.login;

import net.forge.io.StreamBuffer;
import net.forge.net.Passport;
import net.forge.net.exceptions.InvalidPacketException;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.packets.LoginPacket;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipeline;

/**
 * RuneForge | 317
 * FirstStrike.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Handshake extends LoginPacket {

    /**
     * The username hash.
     */
    byte namehash = -1;
    
    /**
     * Validates the packet received.
     * @param passport The players passport.
     * @throws InvalidPacketException 
     *         -Thrown if the packet validation failed.
     */
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
     * Parses the packet.          
     * @param buffer The stream buffer to parse.
     * @throws MalformedPacketException
     *          -Thrown if the packet is malformed or an exception was thrown
     *          when the packet was being parsed.
     */
    @Override
    public void parse(StreamBuffer buffer) throws MalformedPacketException {
        namehash = buffer.getByteBuffer().get();
    }

    /**
     * Writes the response to the client.
     * @param passport The players passport.
     * @param channel The channel to write to.
     */
    @Override
    public void writeResponse(Passport passport, Channel channel) {
        StreamBuffer buffer = new StreamBuffer();
        buffer.put((byte) 0); /* @see UpdateTypes.txt */
        buffer.put((long) passport.getServerKey());
        channel.write(buffer);
    }

    /**
     * Updates the channel pipeline.
     * @param pipline 
     */
    @Override
    public void updatePipeline(ChannelPipeline pipline) {
         /* Nothing to update */
    }

    @Override
    public void fallBack(Passport passport, Channel channel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
