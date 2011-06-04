package net.forge.net.decoders;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.forge.io.StreamBuffer;
import net.forge.io.jagex.RSInputStream;
import net.forge.net.factories.HandlerFactory;
import net.forge.net.packets.LoginPacket;
import net.forge.net.packets.PacketLists;

/**
 * RuneForge | 317
 * LoginPacketDecoder.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class LoginPacketDecoder extends HandlerFactory.Handler {
    
    @Override
    public Object decode(Object[] params) {
        StreamBuffer stream = (StreamBuffer) params[2];
        int id = (stream.getByteBuffer().get() & 0xFF);
        System.out.println("Login id = "+id);
        LoginPacket packet = null;
        try {
            packet = PacketLists.getLoginPacket(id);
            packet.setData(stream);
        } catch (Exception ex) {
        } finally {
            return packet;
        }
    }
}
