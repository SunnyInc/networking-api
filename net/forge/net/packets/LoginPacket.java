package net.forge.net.packets;

import net.forge.net.Passport;
import net.forge.net.SimplePacket;
import net.forge.net.exceptions.InvalidPacketException;
import org.jboss.netty.channel.Channel;

/**
 * RuneForge | 317
 * LoginPacket.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public abstract class LoginPacket extends SimplePacket {
    
    /**
     * Checks and validates the packet.
     * @throws InvalidPacketException Thrown if the validation fails
     */
    public abstract void validate(Passport Passport) throws InvalidPacketException;
    
    /**
     * Applies an appropriate update to the passport.
     * @param passport The passport to update.
     */
    public abstract void applyUpdate(Passport passport);  
    
    /**
     * Writes the response to the channel.
     * @param channel The channel to write the reponse to.
     */
    public abstract void writeResponse(Passport passport, Channel channel);
      
}
