package net.forge.net.channels;

import net.forge.net.HandlerFactory;

/**
 * RuneForge | 317
 * RSLoginChannel.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class RSLoginChannel extends HandlerFactory.Handler {
    
    @Override
    public void connected(Object[] params) {
        System.out.println("[Login]Connection Established!");
    }  
    
    @Override
    public void disconnected(Object[] params) {
        System.out.println("Connection Disconnected!");
    }
    
    @Override
    public void receive(Object[] params) {
        System.out.println("[Login]Message Recieved!");
    }
    
    @Override
    public void error(Object[] params) {
        System.out.println("Exception Thrown?!");
    }
    
}
