package net.forge.net;

import net.forge.io.StreamBuffer;
import net.forge.net.exceptions.MalformedPacketException;

/**
 * RuneForge | 317
 * SimplePacket.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public abstract class SimplePacket {
    
    /**
     * The packets data.
     */
    protected StreamBuffer data;
    
    /**
     * 
     * @param buffer
     * @param params
     * @throws MalformedPacketException 
     */
    public abstract void parse(StreamBuffer buffer) throws MalformedPacketException;
    
    /**
     * Sets the packets data.
     * @param buffer The data.
     */
    public void setData(StreamBuffer buffer) {
        data = buffer;
    }
    
    /**
     * Gets the packets data.
     * @return The packets data.
     */
    public StreamBuffer getData() {
        return data;
    } 
}
