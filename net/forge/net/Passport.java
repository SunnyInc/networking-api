package net.forge.net;

/**
 * RuneForge | 317
 * Passport.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 * 
 * Players login passport/'Customs' control.
 */
public class Passport {
    
    /**
     * 
     */
    SimplePacket packet = null;
    
    /**
     * The username hash from the client.
     */
    byte usernamehash = -1;
    
    /**
     * The sessions client and servers key.
     */
    long clientkey = -1, serverkey = -1;
    
    /**
     * Generates a new server session key.
     */
    public void generateServerKey() {
        serverkey = ((long) (Math.random() * Long.MAX_VALUE) >> 32) |
                    ((long) (Math.random() * Long.MAX_VALUE) << 32);
    }  
    
    /**
     * Gets the client session key.
     * @return The client session key, must be generated first.
     */
    public long getClientKey() {
        return clientkey;
    }
    
    /**
     * Sets the server session key.
     * @param key The server session key.
     */
    public void setClientKey(long key) {
        clientkey = key;
    }
    
    /**
     * Gets the server session key.
     * @return The server session key.
     */
    public long getServerKey() {
        return serverkey;
    }
    
    /**
     * Sets the username hash.
     * @param b The hash value.
     */
    public void setUsernameHash(byte b) {
        usernamehash = b;
    }
    
    /**
     * Gets the username hash.
     * @return The username hash value.
     */
    public byte getUsernameHash() {
        return usernamehash;
    }
    
    /**
     * 
     * @param packet 
     */
    public void setCurrentPacket(SimplePacket packet) {
        this.packet = packet;
    }
}
