package net.forge.net;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/**
 * RuneForge | 317
 * HandlerFactor.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class HandlerFactory {
    
    /**
     * Generates a dynamic channel handler with the ability to receive, catch
     * exceptions, accept connections, and acknowledge disconnections. 
     * @param handler The handler seed to generate the channel handler with.
     * @return The generated channel handler.
     */
    public static ChannelHandler generateChannelHandler(final Handler handler) {
        SimpleChannelHandler channelhandler = new SimpleChannelHandler() {
                       
            @Override
            public final void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
                Object[] params = { ctx, e };
                handler.receive(params);
            } 
            
            @Override
            public final void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent ee) throws Exception {
                Object[] params = { ctx, ee };
                handler.error(params);
            }
            
            @Override
            public final void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
                Object[] params = { ctx, e };
                handler.connected(params);
            }
            
            @Override
            public final void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
                Object[] params = { ctx, e };
                handler.disconnected(params);
            }
        };
        return channelhandler;
    }
    
    /**
     * Generates an encoder which has only one purpose; to decode messages.
     * @param handler The handler to generate the channel handler with.
     * @return 
     */
    public static ChannelHandler generateEncoder(final Handler handler) {
        OneToOneEncoder decoder = new OneToOneEncoder() {

            @Override
            protected Object encode(ChannelHandlerContext chc, Channel chnl, Object o) throws Exception {
                Object[] params = { chc, chnl, o };
                return handler.encode(params);
            }            
        };
        return decoder;
    }
    
    /**
     * Generates a decoder which has only one purpose; to decode messages.
     * @param handler The handler to generate the channel handler with.
     * @return The generated decoder.
     */
    public static ChannelHandler generateDecoder(final Handler handler) {
        OneToOneDecoder decoder = new OneToOneDecoder() {

            @Override
            protected Object decode(ChannelHandlerContext chc, Channel chnl, Object o) throws Exception {
                Object[] params = { chc, chnl, o };
                return handler.decode(params);
            }            
        };
        return decoder;
    }
    
    /**
     * 
     */
    public static abstract class Handler {
        
        /**
         * Called when an connection is accepted.
         * @param params The params of the method.
         */
        public void connected(Object[] params){
            throw new UnsupportedOperationException("Connected not supported on this handler."); 
        }
        
        /**
         * 
         * @param params The params of the method.
         */
        public void disconnected(Object[] params){
            throw new UnsupportedOperationException("Disconnected not supported on this handler."); 
        }
        
        /**
         * Called when a message is received.
         * @param params The params of the method.
         */
        public void receive(Object[] params){
            throw new UnsupportedOperationException("Recieve not supported on this handler."); 
        }
        
        /**
         * Called when a message needs encoding.
         * @param params The params of the method.
         * @return The encoded message.
         */
        public Object encode(Object[] params){ 
            throw new UnsupportedOperationException("Encode not supported on this handler."); 
        }
        
        /**
         * Called when a message needs decoding.
         * @param params The params of the method.
         * @return The decoded message.
         */
        public Object decode(Object[] params){ 
            throw new UnsupportedOperationException("Decode not supported on this handler."); 
        }
        
        /**
         * Called when an exception or error occurs.
         * @param params The params of the method.
         */
        public void error(Object[] params){
            throw new UnsupportedOperationException("Error not supported on this handler."); 
        }
    }   
}
