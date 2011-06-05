package net.forge.content.entities;

/**
 * RuneForge | 317
 * NPC.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class NPC extends Entity {
    
    /**
     * The NPC number.
     */
    private short num;
    
    /**
     * Sets the NPC's id.
     * @param num 
     */
    public void setNumber(short num) {
        this.num = num;
    }
    
    /**
     * 
     * @param num 
     */
    public NPC(short num) {
        this.num = num;
    }

    @Override
    public int getFormattedIndex() {
        return -1;
    }
}
