package org.thiesen.io.applesingle.util;

import java.nio.charset.Charset;

public class Utils {

    private final static Charset ASCII = Charset.forName("ASCII");
    
    public static String stringFromAsciiBytes( final byte[] bytes ) {
        if ( bytes == null ) {
            return null;
        }
        if ( bytes.length == 0 ) {
            return "";
        }
        return new String(bytes, ASCII);
    }
    
}
