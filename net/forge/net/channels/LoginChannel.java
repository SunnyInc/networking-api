package net.forge.net.channels;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.forge.net.exceptions.InvalidPacketException;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.factories.HandlerFactory;
import net.forge.net.Passport;
import net.forge.net.packets.LoginPacket;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;

/**
 * RuneForge | 317
 * LoginChannel.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class LoginChannel extends HandlerFactory.Handler {
    
    @Override
    public void connected(Object[] params){
        ChannelHandlerContext ctx = (ChannelHandlerContext) params[0];
        Passport passport = new Passport();
        ctx.setAttachment(passport);
    }
        
    @Override
    public void disconnected(Object[] params){
        
    }
        
    @Override
    public void receive(Object[] params){
        System.out.println("Recieving");
        Passport passport = (Passport) ((ChannelHandlerContext) params[0]).getAttachment();
        LoginPacket packet = (LoginPacket) ((MessageEvent) params[1]).getMessage();
        passport.setCurrentPacket(packet);
        try {
            packet.parse(packet.getData());
        } catch (MalformedPacketException ex) {
            System.err.println(ex);
            return;
        }
        try {
            packet.validate(passport);
        } catch (InvalidPacketException ex) {
            System.err.println(ex);
            return;
        }
        packet.applyUpdate(passport);
        packet.writeResponse(passport, ((ChannelHandlerContext) params[0]).getChannel());
    }        
        
    @Override
    public void error(Object[] params){
        printError(params);
    }      
}
