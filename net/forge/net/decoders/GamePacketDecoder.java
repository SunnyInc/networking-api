package net.forge.net.decoders;

import net.forge.io.StreamBuffer;
import net.forge.io.jagex.RSInputStream;
import net.forge.net.factories.HandlerFactory;
import net.forge.net.packets.GamePacket;
import net.forge.net.packets.PacketLists;

/**
 * RuneForge | 317
 * PacketDecoder.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class GamePacketDecoder extends HandlerFactory.Handler {
    
    @Override
    public Object decode(Object[] params) {
        System.out.println("game decoding");
        RSInputStream stream = (RSInputStream) params[2];
        int id = (stream.getByteBuffer().get() & 0xFF);
        System.out.println("Packet id = "+id);
        GamePacket packet = null;
        try {
            packet = PacketLists.getGamePacket(id);
            packet.setData(stream);
        } catch (Exception ex) {
        } finally {
            return packet;
        }
    }
}
