package net.forge.net.channels;

import net.forge.net.Passport;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.factories.HandlerFactory;
import net.forge.net.packets.GamePacket;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

/**
 * RuneForge | 317
 * GameChannel.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class GameChannel extends HandlerFactory.Handler {
        
    @Override
    public void disconnected(Object[] params){
        
    }
        
    @Override
    public void receive(Object[] params){
        Passport passport = (Passport) ((ChannelHandlerContext) params[0]).getAttachment();
        GamePacket packet = (GamePacket) ((MessageEvent) params[1]).getMessage();            
        try {
            packet.parse(packet.getData());
        } catch (MalformedPacketException ex) {
            System.err.println(ex);
            return;
        }
        packet.execute(passport);
    }        
        
    @Override
    public void error(Object[] params){
        printError(params);
    }       
}
