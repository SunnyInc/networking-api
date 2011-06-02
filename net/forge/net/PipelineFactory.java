package net.forge.net;

import net.forge.net.channels.RSGameChannel;
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
     * Enumerated Pipeline HandlerSet
     */
    public static enum HandlerSets {
        
        /**
         * Pre-made Handler sets
         */
        GAME_HANDLERS(new Object[] {
                        "handler",
                        HandlerFactory.generateChannelHandler(new RSGameChannel())
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
