/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.forge.content.entities.impl;

/**
 *
 * @author Hadyn Fiztgerald
 */
public interface Identifiable<T> {
    
    /**
     * Gets the identification generic of the entity.
     * @return The identification generic.
     */
    public abstract T identification();
    
    /**
     * Compares the identification generic to see if they are equal.
     * @return If the two are equal.
     */
    public abstract boolean compare(T obj);
    
}
