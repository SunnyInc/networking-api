package net.forge.net.packets;

import net.forge.net.packets.login.Information;
import net.forge.net.packets.login.Initial;

/**
 * RuneForge | 317
 * PacketLists.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class PacketLists {
        
    /**
     * The packets list, both login/game are held here.
     */
    private static final Class[] PACKETS = new Class[256];
    
    /**
     * 
     * @param id
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public static LoginPacket getLoginPacket(int id) throws InstantiationException,
                                                     IllegalAccessException {
        if(PACKETS[id] == null)
            return null;
        return (LoginPacket) PACKETS[id].newInstance();
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws InstantiationException Invalid instantiation.
     * @throws IllegalAccessException Illegal access.
     */
    public static GamePacket getGamePacket(int id) throws InstantiationException,
                                                   IllegalAccessException {
        if(PACKETS[id] == null)
            return null;
        return (GamePacket) PACKETS[id].newInstance();
    }
    
    /**
     * Initialize both lists.
     */
    static {
        /* Initialize Login Packets */
        PACKETS[14] = Initial.class;
        PACKETS[16] = Information.class;
        /* Initialize Game Packets  */
    }
}
