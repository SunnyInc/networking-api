package net.forge.net;

import net.forge.net.channels.RSGameChannel;
import net.forge.net.channels.RSLoginChannel;
import net.forge.net.decoders.RSGameDecoder;
import net.forge.util.Tools;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;

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
     * Switches the pipelines channel handler to a new new one.
     * @param pipeline The pipeline to change the handlers for.
     * @param handler The handler to switch to.
     */    
    public static void switchHandlers(ChannelPipeline pipeline, HandlerFactory.Handler handler) {
        pipeline.remove("handler");
        pipeline.addLast("handler", HandlerFactory.generateChannelHandler(handler));
    }
    
    /**
     * Changes all handlers to the new HandlerSet.
     * @param pipeline The pipeline to change the handlers for.
     * @param HandlersSet The handler set to put into the pipeline,
     *        already added channel handlers with the same name will be removed.
     */
    public static void switchHandlers(ChannelPipeline pipeline, HandlerSets set) {
        for(int pos = 0; pos < set.params.length; pos++) {
            String name = (String) set.params[pos][0];
            if(pipeline.get(name) != null)
                pipeline.remove(name);
            pipeline.addLast(name, (ChannelHandler) set.params[pos][1]);
        }
    }
    
    /**
     * Enumerated Pipeline HandlerSet
     */
    public static enum HandlerSets {
        
        /**
         * Pre-made Handler sets
         */
        GAME_HANDLERS(new Object[] {
            "handler",
            HandlerFactory.generateChannelHandler(new RSGameChannel())
        }),
        
        LOGIN_HANDLER(
                      new Object[] {
            "decoder",
            HandlerFactory.generateDecoder(new RSGameDecoder())
        },
                      new Object[] {
            "handler",
            HandlerFactory.generateChannelHandler(new RSLoginChannel()),           
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
