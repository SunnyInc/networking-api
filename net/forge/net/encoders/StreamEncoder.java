package net.forge.net.encoders;

import net.forge.io.StreamBuffer;
import net.forge.net.factories.HandlerFactory;
import org.jboss.netty.buffer.ChannelBuffers;

/**
 * RuneForge | 317
 * StreamEncoder.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class StreamEncoder extends HandlerFactory.Handler {
    
    @Override
    public Object encode(Object[] params) {
        System.out.println("Encoding");
        StreamBuffer buffer = (StreamBuffer) params[2];       
        return ChannelBuffers.copiedBuffer(buffer.getByteBuffer().array(), 0, buffer.getByteBuffer().position());
    }   
}
