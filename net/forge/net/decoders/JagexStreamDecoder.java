package net.forge.net.decoders;

import net.forge.io.jagex.RSInputStream;
import net.forge.net.factories.HandlerFactory;
import org.jboss.netty.buffer.ChannelBuffer;

/**
 * RuneForge | 317
 * StreamDecoder.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 * 
 * Converts the bytes of the incoming message into a RSInputStream.
 */
public class JagexStreamDecoder extends HandlerFactory.Handler {
    
    @Override
    public Object decode(Object[] params) {
        ChannelBuffer chnlbuf = (ChannelBuffer) params[2];
        chnlbuf.markReaderIndex();
        int avail = chnlbuf.readableBytes();
        byte[] bytes = new byte[avail];
        chnlbuf.readBytes(bytes);
        RSInputStream stream = new RSInputStream(bytes);
        return stream;
    }
}
