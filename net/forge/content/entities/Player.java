package net.forge.content.entities;

import net.forge.content.entities.impl.Identifiable;
import net.forge.net.Passport;

/**
 * RuneForge | 317
 * Player.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 * @Reviewed by; Somebodyy (david1kyle2@hotmail.com)
 */
public class Player extends Drone implements Identifiable<String> {
    
    /**
     * The players network passport.
     */
    private Passport passport = null;

    @Override
    public String identification() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean compare(String obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
