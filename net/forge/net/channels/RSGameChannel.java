package net.forge.net.channels;

import net.forge.net.HandlerFactory;
import net.forge.net.PipelineFactory;
import net.forge.net.PipelineFactory.HandlerSets;
import org.jboss.netty.channel.ChannelHandlerContext;

/**
 * RuneForge | 317
 * RSGameChannel.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class RSGameChannel extends HandlerFactory.Handler {
    
    @Override
    public void connected(Object[] params) {
        System.out.println("[Game]Connection Established!");
        ChannelHandlerContext ctx = (ChannelHandlerContext) params[0];
        PipelineFactory.switchHandlers(ctx.getPipeline(), HandlerSets.LOGIN_HANDLER);
    }  
    
    @Override
    public void disconnected(Object[] params) {
        System.out.println("Connection Disconnected!");
    }
    
    @Override
    public void receive(Object[] params) {
        System.out.println("[Game]Message Recieved!");
    }
    
    @Override
    public void error(Object[] params) {
        System.out.println("Exception Thrown?!");
    }
}
