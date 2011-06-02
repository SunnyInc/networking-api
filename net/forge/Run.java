package net.forge;

import net.forge.io.StreamBuffer;
import net.forge.net.BootstrapFactory;
import net.forge.net.BootstrapFactory.OptionSets;
import net.forge.net.PipelineFactory;
import net.forge.net.PipelineFactory.HandlerSets;
import org.jboss.netty.bootstrap.ServerBootstrap;

/**
 * RuneForge | 317
 * Run.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Run {
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        ServerBootstrap bootstrap = BootstrapFactory.createServerBootstrap(OptionSets.GAME_SERVER, PipelineFactory.generatePipeline(HandlerSets.GAME_HANDLERS));
        bootstrap.bind();
        System.out.println(System.currentTimeMillis());
    }
}
