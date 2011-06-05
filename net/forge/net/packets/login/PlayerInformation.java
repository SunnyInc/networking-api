package net.forge.net.packets.login;

import java.math.BigInteger;
import net.forge.io.StreamBuffer;
import net.forge.io.jagex.RSInputStream;
import net.forge.net.Passport;
import net.forge.net.exceptions.InvalidPacketException;
import net.forge.net.exceptions.MalformedPacketException;
import net.forge.net.factories.PipelineFactory;
import net.forge.net.factories.PipelineFactory.HandlerSets;
import net.forge.net.packets.LoginPacket;
import net.forge.Constants;
import net.forge.util.TextUtilities;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipeline;

/**
 * RuneForge | 317
 * PlayerInformation.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class PlayerInformation extends LoginPacket implements Constants {
    
    /**
     * The servers response to the packet.
     */
    ResponseCodes response = null;
    
    /**
     * The username/password strings.
     */
    String username = null, password = null;
    
    /**
     * If the player is using a low memory setting or not.
     */
    boolean lowmemory = false;
    
    /**
     * The cache sizes according to the client.
     */
    int[] cachesizes = new int[9];
    
    short
            /**
             * Unique identification number.
             */
            uid = -1;
    
    int 
       /**
        * The non encrypted block validation check.
        */
        validationchk = -1, 
            
        /**
         * The revision of the client.
         */
        revision = -1;
    
    long
            /**
             * The server session key.
             */
            serverkey = -1,
            
            /** 
             * The parsed client session key.
             */
            clientkey = -1;
    
    @Override
    public void validate(Passport passport) throws InvalidPacketException {
        /* Validate the non encrypted start */
        if(validationchk != 255) { 
            response = ResponseCodes.FAILED;
            throw new InvalidPacketException("Invalid non encrypted block validation - "+validationchk);
        }
        
        /* Validate revision */
        if(revision != 317) {
            response = ResponseCodes.INVALID_REVISION;
            throw new InvalidPacketException("Invalid revision - "+revision);
        }
        
        /* Validate server key */
        if(passport.getServerKey() != serverkey) {
            response = ResponseCodes.BAD_SESSION;
            throw new InvalidPacketException("Invalid server key - "+serverkey);
        }
        
        /* Validate the username & password */
        if(!TextUtilities.validUsername(username)) {
            response = ResponseCodes.INVALID_USER_PASS;
            throw new InvalidPacketException("Invalid username | password");
        }
        
        /* Validate username hash */
        byte hash = (byte) (TextUtilities.stringToLong(username) >> 16 & 31L);
        if(hash != passport.getUsernameHash()) {
            response = ResponseCodes.FAILED;
            throw new InvalidPacketException("Invalid username hash - "+hash);
        }
    }

    @Override
    public void applyUpdate(Passport passport) {
        passport.setClientKey(clientkey);
    }

    @Override
    public void parse(StreamBuffer buffer) throws MalformedPacketException {
        try {
            int packetsize = (buffer.getByteBuffer().get() & 0xFF);
            int encryptsize = packetsize - (36 + 1 + 1 + 2);
            validationchk = (buffer.getByteBuffer().get() & 0xFF);
            revision = (buffer.getByteBuffer().getShort() & 0xFFFF);
            lowmemory = (buffer.getByteBuffer().get() & 0xFF) == 1;
            for(int pos = 0; pos < cachesizes.length; pos++)
                cachesizes[pos] = buffer.getByteBuffer().getInt();
            int check = (buffer.getByteBuffer().get() & 0xFF);
            if(check != --encryptsize)
                throw new MalformedPacketException("Invalid encryption block.");  
            byte[] encryptedblock = new byte[encryptsize];
            buffer.getByteBuffer().get(encryptedblock);
            parseEncryptedBlock(new RSInputStream(new BigInteger(encryptedblock).
            modPow(new BigInteger(RSA_EXPONENT), new BigInteger(RSA_MODULUS)).
            toByteArray()));
        } catch(Exception ex) {
            throw new MalformedPacketException(ex.getMessage());
        }
    }

    /**
     * Writes the final login response.
     * @param passport
     * @param channel 
     */
    @Override
    public void writeResponse(Passport passport, Channel channel) {
        response = ResponseCodes.SUCCESS;
        switch(response) {
            /**
             * Login was a success.
             * [Rights, Unknown]
             */
            case SUCCESS:
                response.buffer.put((byte) 2);
                response.buffer.put((byte) 0);
                break;
                
            /**
             * Fall back if the response is not handled.
             */
            default:
                fallBack(passport, channel);
                return;       
        }
        channel.write(response.buffer);
        PipelineFactory.switchHandlers(channel.getPipeline(), HandlerSets.GAME_HANDLER);
        PipelineFactory.switchHandlers(channel.getPipeline(), HandlerSets.GAME_HANDLER);
    }

    /**
     * Switches the pipelines handlers over to the game handler set.
     * @param pipeline The pipeline to update.
     */
    @Override
    public void updatePipeline(ChannelPipeline pipeline) {
        PipelineFactory.switchHandlers(pipeline, HandlerSets.GAME_HANDLER);
    }
    
    /**
     * Parses the encrypted block of the packet.
     * @param buffer The buffer to parse.
     * @throws MalformedPacketException Thrown if the RSA check fails
     */
    private void parseEncryptedBlock(RSInputStream buffer) throws MalformedPacketException {
        if((buffer.getByteBuffer().get() & 0xFF) != 10)
            throw new MalformedPacketException("Invalid RSA Check");
        clientkey = buffer.getByteBuffer().getLong();
        serverkey = buffer.getByteBuffer().getLong();
        uid = buffer.getByteBuffer().getShort();
        username = buffer.getString();
        password = buffer.getString();
    }

    @Override
    public void fallBack(Passport passport, Channel channel) {
        channel.write(response.buffer);
        channel.close();
    }
    
    /**
     * Server response codes to the client.
     */
    enum ResponseCodes {
        
        /**
         * Pre made response codes.
         */
        SUCCESS(new StreamBuffer().put((byte) 2)),
        INVALID_USER_PASS(new StreamBuffer().put((byte) 3)),
        INVALID_REVISION(new StreamBuffer().put((byte) 6)),
        BAD_SESSION(new StreamBuffer().put((byte) 10)),
        FAILED(new StreamBuffer().put((byte) 13));
        
        /**
         * The response to the client.
         */
        private StreamBuffer buffer = null;
        
        /**
         * ReponseCodes Constructor;
         * @param response The response to the client to write.
         */
        ResponseCodes(StreamBuffer buffer) {
            this.buffer = buffer;
        }
    }
}
