package net.forge.io.jagex;

import net.forge.io.StreamBuffer;

/**
 * RuneForge | 317
 * RSInputStream.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class RSInputStream extends StreamBuffer {
    
    /**
     *
     * @return
     */
    public String getString() {
        String s = "";
        byte b;
        while((b = getByteBuffer().get()) != 10) {
            s += (char) b;
        }
        return s;
    }
    
    /**
     * 
     * @param bytes 
     */
    public RSInputStream(byte[] bytes) {
        super(bytes);
    }
}
