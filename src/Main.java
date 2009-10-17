import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.thiesen.io.applesingle.AppleSingleReader;
import org.thiesen.io.applesingle.AppleSingleResourceForkInputStream;
import org.thiesen.io.applesingle.model.AppleSingle;


public class Main {

    public static void main( final String... args ) throws IOException {
        testReadFile();
        extractResourceForkFile();
    }

    private static void extractResourceForkFile() throws IOException,
            FileNotFoundException {
        final AppleSingleResourceForkInputStream resourceForkStream = new AppleSingleResourceForkInputStream(makeInputStream());
        final FileOutputStream out = new FileOutputStream(new File(resourceForkStream.getRealName()));
        
        IOUtils.copy(resourceForkStream, out);
        IOUtils.closeQuietly(out);
        IOUtils.closeQuietly(resourceForkStream);
    }

    private static void testReadFile() throws FileNotFoundException,
            IOException {
        final AppleSingleReader reader = new AppleSingleReader( makeInputStream() );
        
        AppleSingle read = reader.read();
        
        System.out.println(read);
    }

    private static FileInputStream makeInputStream()
            throws FileNotFoundException {
        return new FileInputStream("test.file");
    }
    
}
