package net.forge.content.world;

import net.forge.content.entities.Entity;

/**
 * RuneForge | 317
 * EntityStorage.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class EntityStorage<E extends Entity> {
    
    /**
     * The storage array for the entities.
     */
    Entity[] storage = null;
    
    /**
     * EntityStorage Constructor;
     * @param size The maximum size of storage.
     */
    EntityStorage(int size) {
        this.storage = new Entity[size];
    }
}
