package net.forge.net.factories;

import net.forge.net.factories.HandlerFactory;
import net.forge.net.channels.GameChannel;
import net.forge.net.channels.LoginChannel;
import net.forge.net.channels.UpdateChannel;
import net.forge.net.decoders.GamePacketDecoder;
import net.forge.net.decoders.JagexStreamDecoder;
import net.forge.net.decoders.LoginPacketDecoder;
import net.forge.net.decoders.StreamDecoder;
import net.forge.net.encoders.StreamEncoder;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import net.forge.util.Tools;

/**
 * RuneForge | 317
 * PipelineFactory.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class PipelineFactory {
    
    /**
     * Generates a pipeline
     * @return The generated pipeline.
     */
    public static ChannelPipeline generatePipeline(HandlerSets set) {
        ChannelPipeline pipeline = Channels.pipeline();       
        for(int pos = 0; pos < set.params.length; pos++) {
            pipeline.addLast((String) set.params[pos][0], (ChannelHandler) set.params[pos][1]);
        }
        return pipeline;
    } 
    
    /**
     * Changes all handlers to the new HandlerSet.
     * @param pipeline The pipeline to change the handlers for.
     * @param HandlersSet The handler set to put into the pipeline,
     *        already added channel handlers with the same name will be removed.
     */
    public static void switchHandlers(ChannelPipeline pipeline, HandlerSets set) {
        while(pipeline.getLast() != null)
            pipeline.removeLast();
        for(int pos = 0; pos < set.params.length; pos++) {
            pipeline.addLast((String) set.params[pos][0], (ChannelHandler) set.params[pos][1]);
        }
    }
    
    /**
     * Enumerated Pipeline HandlerSet
     */
    public static enum HandlerSets {
        
        /**
         * Pre-made Handler sets
         */
        GAME_HANDLER(new Object[] {
            "rs stream decoder",
            HandlerFactory.generateDecoder(new JagexStreamDecoder()),           
        }, new Object[] {
            "game packet decoder",
            HandlerFactory.generateDecoder(new GamePacketDecoder()),           
        }, new Object[] {
            "encoder",
            HandlerFactory.generateEncoder(new StreamEncoder()),           
        }, new Object[] {           
            "handlerr",
            HandlerFactory.generateChannelHandler(new GameChannel())
        }),
        
        LOGIN_HANDLER(new Object[] {
            "stream decoder",
            HandlerFactory.generateDecoder(new StreamDecoder()),           
        }, new Object[] {
            "login packet decoder",
            HandlerFactory.generateDecoder(new LoginPacketDecoder()),           
        }, new Object[] {
            "encoder",
            HandlerFactory.generateEncoder(new StreamEncoder()),           
        }, new Object[] {
            "handler",
            HandlerFactory.generateChannelHandler(new LoginChannel()),           
        }),
        
        UPDATE_HANDLER(new Object[] {
            "handler",
            HandlerFactory.generateChannelHandler(new UpdateChannel()),
        });
        
        /**
         * The handlers parameters.
         */
        Object[][] params = null;
        
        /**
         * HandlerSets Constructor;
         * @param handlersets The set of handler objects to bundle.
         */
        HandlerSets(Object[]... handlersets) {
            params = Tools.bundle(handlersets);
        }
    }
}
