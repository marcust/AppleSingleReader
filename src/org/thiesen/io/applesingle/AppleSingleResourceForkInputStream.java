package org.thiesen.io.applesingle;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.CheckForNull;

import org.thiesen.io.applesingle.model.AppleSingle;

public class AppleSingleResourceForkInputStream extends InputStream {

    private final InputStream _resourceForkInputStream;
    private String _realName;
    
    public AppleSingleResourceForkInputStream(final InputStream in) throws IOException {
        final AppleSingleReader reader = new AppleSingleReader(in);
        final AppleSingle appleSingle = reader.read();
        
        _resourceForkInputStream = appleSingle.getResourceForkStream();
        _realName = appleSingle.getRealName();
        if ( _resourceForkInputStream == null ) {
            throw new IOException("Can't find resource fork in apple single file!");
        }
    }
    
    public @CheckForNull String getRealName() {
        return _realName;
    }
    
    @Override
    public int read() throws IOException {
        return _resourceForkInputStream.read();
    }

}
