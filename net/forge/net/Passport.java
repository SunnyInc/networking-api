package net.forge.net;

import net.forge.content.entities.Drone;

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
     * The current packet being parsed.
     */
    SimplePacket packet = null;
    
    /**
     * The passports player.
     */
    Drone player = null;
    
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
     * Sets the current packet.
     * @param packet The packet being parsed.
     */
    public void setCurrentPacket(SimplePacket packet) {
        this.packet = packet;
    }
    
    /**
     * Sets the player.
     * @param player The player to set.
     */
    public void setPlayer(Drone player) {
        this.player = player;
    }
    
    /**
     * Gets the player.
     * @return The passports player.
     */
    public Drone getPlayer() {
        return player;
    }
}
