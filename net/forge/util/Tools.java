package net.forge.util;

/**
 * RuneForge | 317
 * Tools.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Tools {
    
    /**
     * Bundle many handlers into a set of an object and a string. 
     * @param handlers The obj to bundle. Object[] = {(String), (ChannelHandler)}
     * @return The bundled handlers.
     */
    public static Object[][] bundle(Object[]... objs) {
        Object[][] bundle = new Object[objs.length][2];
        System.arraycopy(objs, 0, bundle, 0, objs.length);
        return bundle;
    }
}
