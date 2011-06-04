package net.forge.util;

/**
 * RuneForge | 317
 * Constants.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public interface Constants {
    
    /**
     * Incoming packet sizes.
     */
    int[] PACKET_SIZES = {
        0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 6, 2, 2, 0,
        0, 2, 0, 6, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 4, 0, 0, 2,
        2, 6, 0, 6, 0, -1, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 8, 0,
        0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 2, 2, 8, 6, 0, -1, 0, 6,
        0, 0, 0, 0, 0, 1, 4, 6, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -1, 0,
        0, 13, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0,
        1, 0, 6, 0, 0, 0, -1, 0, 2, 6, 0, 4, 6, 8, 0, 6, 0, 0, 0, 2,
        0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 6, 0, 0, 0,
        0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 8, 0, 3, 0, 2, 0, 0, 8, 1, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0,
        2, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 7, 8, 0, 0, 10, 0,
        0, 0, 0, 0, 0, 0, -1, 0, 6, 0, 1, 0, 0, 0, 6, 0, 6, 8, 1, 0,
        0, 4, 0, 0, 0, 0, -1, 0, -1, 4, 0, 0, 6, 6, 0, 0, 0
    };
    
    /**
     * The public RSA modulus.
     */
    String RSA_MODULUS = "981012326571499187065184668975404420604104746115327143"
                       + "425398364023255266034839499203283523268032241887665517"
                       + "949046293012131920368658499115639817773794790080727109"
                       + "055979471703170973700925588352736539966824288380022294"
                       + "088721610229958537960939017309260626929024154250671410"
                       + "78879053996044981697505716670498887731";
    
    /**
     * The private RSA exponent.
     */
    String RSA_EXPONENT = "97836284335128533296581274645211762715236105110239684"
                        + "59692087991906856308350566804694540653493230897016619"
                        + "35290746688302377928731793025347486434986270770201359"
                        + "04986185960311851143068829754947029086352315904265928"
                        + "67356413657484326400183366600836137381670917017596431"
                        + "5954102425237599984332128389328431807275393";
    
}