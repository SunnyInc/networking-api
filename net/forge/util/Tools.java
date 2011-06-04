package net.forge.util;

/**
 * RuneForge | 317
 * Tools.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class Tools {
    
    /**
     * Bundle many objects into a set of an object and a string. 
     * @param handlers The objects to bundle. Object[] = {(String), (Object)};
     * @return The bundled handlers.
     */
    public static Object[][] bundle(Object[]... objs) {
        Object[][] bundle = new Object[objs.length][2];
        System.arraycopy(objs, 0, bundle, 0, objs.length);
        return bundle;
    }
    
    /**
     * Gets the integer value of an IP string.
     * @param ip The IP to get the value for.
     * @return The integer representation of the IP.
     */
    public int getIPValue(String ip) {
        int value = 0, offset = 0;
        String[] data = ip.replace(".", " ").split(" ");
        for(String s : data) {
            value += (Integer.parseInt(s) << (offset++ * 8));
        }
        return value;
    }
}
