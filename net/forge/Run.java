package net.forge;

import org.jboss.netty.bootstrap.ServerBootstrap;
import net.forge.net.factories.BootstrapFactory;
import net.forge.net.factories.BootstrapFactory.OptionSets;
import net.forge.net.factories.PipelineFactory.HandlerSets;
import net.forge.net.factories.PipelineFactory;

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
        long cur = System.currentTimeMillis();
        ServerBootstrap bootstrap = BootstrapFactory.createServerBootstrap(OptionSets.GAME_SERVER, PipelineFactory.generatePipeline(HandlerSets.LOGIN_HANDLER));
        bootstrap.bind();
        ServerBootstrap bootstra = BootstrapFactory.createServerBootstrap(OptionSets.UPDATE_SERVER, PipelineFactory.generatePipeline(HandlerSets.UPDATE_HANDLER));
        bootstra.bind();
        System.out.println(System.currentTimeMillis() - cur);
    }
}
