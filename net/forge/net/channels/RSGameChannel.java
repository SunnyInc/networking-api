package net.forge.net.channels;

import net.forge.net.HandlerFactory;

/**
 * RuneForge | 317
 * RSGameChannel.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class RSGameChannel extends HandlerFactory.Handler {
    
    @Override
    public void connected(Object[] params) {
        System.out.println("Connection Established!");
    }  
    
    @Override
    public void disconnected(Object[] params) {
        System.out.println("Connection Disconnected!");
    }
    
    @Override
    public void receive(Object[] params) {
        System.out.println("Message Recieved!");
    }
    
    @Override
    public void error(Object[] params) {
        System.out.println("Exception Thrown?!");
    }
}
