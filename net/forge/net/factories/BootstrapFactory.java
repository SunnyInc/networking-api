package net.forge.net.factories;

import java.net.InetSocketAddress;
import java.util.HashMap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.bootstrap.ServerBootstrap;
import java.util.concurrent.Executors;
import java.util.Map;
import net.forge.util.Tools;
import org.jboss.netty.channel.ChannelPipeline;

/**
 * RuneForge | 317
 * BootstrapFactory.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class BootstrapFactory {
    
    /**
     * Generates a new server bootstrap.
     * @param set The option set to create the bootstrap with.
     * @return The created server bootstrap.
     */
    public static ServerBootstrap createServerBootstrap(OptionSets set, ChannelPipeline pipeline) {
        ServerBootstrap bootstrap = createServerBootstrap(generateOptions(set.params));
        bootstrap.setPipeline(pipeline);
        return bootstrap;
    }

    /**
     * Generates a new server bootstrap.
     * @param options The options to set the bootstrap with.
     * @return The created server bootstrap.
     */
    private static ServerBootstrap createServerBootstrap(Map<String, Object> options) {       
        ServerBootstrap bootstrap = new ServerBootstrap(generateSocketChannel());                
        bootstrap.setOptions(options);
        return bootstrap;
    }     
    
    /**
     * Simple generator method; creates a new NioServerSocketChannelFactory.
     * @return The created NioServerSocketChannelFactory.
     */
    private static NioServerSocketChannelFactory generateSocketChannel() {
        return new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),
                                                 Executors.newCachedThreadPool());
    }
    
    /**
     * Generates an option map off a parameter set.
     * @param params The options key and value parameters. 
     * @return The generated option map.
     */
    private static Map<String, Object> generateOptions(Object[][] params) {
        Map<String, Object> options = new HashMap<String, Object>();
        for(int pos = 0; pos < params.length; pos++) 
            options.put((String) params[pos][0], params[pos][1]);
        return options;
    }
    
    /**
     * Enumerated Bootstrap OptionsSets
     */
    public static enum OptionSets {
        /**
         * Pre-made Option sets
         */
        GAME_SERVER(new Object[]   { "child.tcpNoDelay", Boolean.TRUE },
                    new Object[]   { "localAddress", new InetSocketAddress(43594) }),
        
        UPDATE_SERVER(new Object[] { "child.tcpNoDelay", Boolean.TRUE },
                      new Object[] { "localAddress", new InetSocketAddress(43595) });
        
        /**
         * The OptionSets parameters.
         */
        private Object[][] params = null;
        
        /**
         * OptionSets Constructor;
         * @param paramsets The parameter sets.
         */
        OptionSets(Object[]... paramsets) {
            params = Tools.bundle(paramsets);
        }
    }
}
