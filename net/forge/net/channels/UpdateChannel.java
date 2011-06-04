package net.forge.net.channels;

import net.forge.net.factories.HandlerFactory;

/**
 * RuneForge | 317
 * UpdateChannel.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 * 
 * The channel for update server requests.
 */
public class UpdateChannel extends HandlerFactory.Handler {
    
    @Override
    public void connected(Object[] params){
        
    }
        
    @Override
    public void disconnected(Object[] params){
        
    }
        
    @Override
    public void receive(Object[] params){
        
    }        
        
    @Override
    public void error(Object[] params){
        printError(params);
    }    
}
