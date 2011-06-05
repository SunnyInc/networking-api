package net.forge.util;

/**
 * RuneForge | 317
 * TextUtilities.java
 * @version 1.0.0
 * @author SiniSoul (SiniSoul@live.com)
 */
public class TextUtilities {
    
    /**
     * Converts a string into its long value.
     * @param s The string to convert.
     * @return The long value of the string.
     */
    public static long stringToLong(String s){
        long l = 0L;
        for(int i = 0; i < s.length() && i < 12; i++){
            char c = s.charAt(i);
            l *= 37L;
            if(c >= 'A' && c <= 'Z')
                l += (1 + c) - 65;
            else
            if(c >= 'a' && c <= 'z')
                l += (1 + c) - 97;
            else
            if(c >= '0' && c <= '9')
                l += (27 + c) - 48;
        }
        for(; l % 37L == 0L && l != 0L; l /= 37L);
        return l;
    }  
    
    /**
     * Converts a long into its string value.
     * @param l The long to convert.
     * @return The string value of the long.
     */
    public static String longToString(long l)  {
        try {
            if(l <= 0L || l >= 0x5b5b57f8a98a5dd1L)
                return "invalid_name";
            if(l % 37L == 0L)
                return "invalid_name";
            int i = 0;
            char ac[] = new char[12];
            while(l != 0L) 
            {
                long l1 = l;
                l /= 37L;
                ac[11 - i++] = VALID_CHARS[(int)(l1 - l * 37L)];
            }
            return new String(ac, 12 - i, i);
        } catch(RuntimeException runtimeexception) {}
        throw new RuntimeException();
    }
    
    /**
     * 
     * @param username The username to check.
     * @return 
     */
    public static boolean validUsername(String username) {
        username = username.toLowerCase();
        for(String chk : INVALID_USRNAMES)
            if(username.equals(chk))
                return false;
        return true;
    }
    
    /**
     * A list of invalid usernames.
     */
    private static final String[] INVALID_USRNAMES = {
        "", " ", "admin"
    };
    
    /**
     * The list of valid characters for the Long -> String/String -> Long
     */
    private static final char VALID_CHARS[] = {
        '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
        't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9'
    };
}
