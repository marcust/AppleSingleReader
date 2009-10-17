import java.io.FileInputStream;
import java.io.IOException;

import org.thiesen.io.applesingle.AppleSingleReader;
import org.thiesen.io.applesingle.model.AppleSingle;


public class Main {

    public static void main( final String... args ) throws IOException {
        final AppleSingleReader reader = new AppleSingleReader( new FileInputStream("test.file") );
        
        AppleSingle read = reader.read();
        
        System.out.println(read);
    }
    
}
