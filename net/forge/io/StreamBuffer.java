package net.forge.io;

import java.nio.ByteBuffer;

/**
 * RuneForge | 317
 * StreamBuffer.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 * 
 * When putting variables into the buffer, it will be truncated based upon
 * what type of variable it is so be cautious when writing. Cast everything to
 * what you want it to write or else it will write what the variable actually is.
 */
public class StreamBuffer {
    
    /**
     * The streams byte buffer.
     */
    private ByteBuffer buffer;
    
    /**
     * Puts a byte into the buffer.
     * @param b The byte to put.
     */
    public void put(byte b) {
        if(doExpand(1))
            expand(1);
        buffer.put(b);
    }
    
    /**
     * Puts a byte into the buffer.
     * @param b The byte to put.
     * @param pos The position to put the byte at.
     */
    public void put(byte b, int pos) {
        buffer.put(pos, b);
    }
    
    /**
     * Puts a short into the buffer.
     * @param s The short to put.
     */
    public void put(short s) {
        if(doExpand(2))
            expand(2);
        buffer.putShort(s);
    }
    
    /**
     * Puts a short into the buffer.
     * @param s The short to put.
     * @param pos The position to put the short at.
     */
    public void put(short s, int pos) {
        buffer.putShort(pos, s);
    }
    
    /**
     * Puts an integer into the buffer.
     * @param i  The integer to put.
     */
    public void put(int i) {
        if(doExpand(4))
            expand(4);
        buffer.putInt(i);
    }
    
    /**
     * Puts an integer into the buffer.
     * @param i The integer to put.
     * @param pos The position to put the integer at.
     */
    public void put(int i, int pos) {
        buffer.putInt(pos, i);
    }
    
    /**
     * Puts a long into the buffer.
     * @param l The long to put.
     */
    public void put(long l) {
        if(doExpand(8))
            expand(8);
        buffer.putLong(l);
    }
    
    /**
     * Puts a long into the buffer.
     * @param l The long to put.
     * @param pos The position to put the long at.
     */
    public void put(long l, int pos) {
        buffer.putLong(pos, l);
    }
    
    /**
     * Checks if an expansion is necessary for the amount of bytes that need to
     * be written into the buffer. If the amount of remaining bytes in the buffer
     * is less than the amount of bytes that are needed to be written returns false.
     * @param amt The amount of bytes.
     * @return If an expansion of the buffer is necessary. 
     */
    public boolean doExpand(int amt) {
        return buffer.remaining() <= amt;
    }
    
    /**
     * Expands the stream buffer.
     * @param amt The amount of bytes to expand the stream by.
     */
    public void expand(int amt) {
       int pos = buffer.position();
       ByteBuffer buf = ByteBuffer.allocate(buffer.capacity() + amt);
       buf.put(buffer);
       buffer = ByteBuffer.wrap(buf.array());
       buffer.position(pos);
    }
    
    /**
     * Gets the bytes from the buffer.
     * @return The bytes in the buffer.
     */
    public byte[] getBytes() {
        return buffer.array();
    }
    
    /**
     * Gets the base byte buffer; which all things perpetuate around.
     * @return The base byte buffer.
     */
    public ByteBuffer getByteBuffer() {
        return buffer;
    }

    /**
     * StreamBuffer Constructor;
     * Allocates for 0 for constant expanding.
     */
    public StreamBuffer() {
        buffer = ByteBuffer.allocate(0);
    }
    
    /**
     * StreamBuffer Constructor;
     * Wraps the bytes into a new buffer.
     * @param bytes The bytes to put into the buffer.
     */
    public StreamBuffer(byte[] bytes) {
        buffer = ByteBuffer.wrap(bytes);
    }
}
