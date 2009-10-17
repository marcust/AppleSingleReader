package org.thiesen.io.applesingle;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.annotation.Nonnull;

import org.apache.commons.io.IOUtils;
import org.thiesen.io.applesingle.beans.EntryId;
import org.thiesen.io.applesingle.model.AppleSingle;
import org.thiesen.io.applesingle.model.Entry;
import org.thiesen.io.applesingle.util.Utils;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;


/**
 * See http://www.faqs.org/rfcs/rfc1740.html
 * 
 */
public class AppleSingleReader {

    private final InputStream _inStream;

    public AppleSingleReader(InputStream inputStream) {
        _inStream = new DataInputStream(inputStream);
        
    }

    public AppleSingle read() throws IOException {
        final byte[] data = IOUtils.toByteArray(_inStream); 
        
        final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(data));
        final int magicNumber = readMagicNumber(stream);
        final int versionNumber = readVersionNumber(stream);
        readHomeFileSysstem(stream);
        final short numberOfEnties = readNumberOfEntries(stream);
        
        final ImmutableCollection<Entry> entryDataEntries = readAllEntries(data, stream,
                numberOfEnties);
        
        return AppleSingle.fromRawData( magicNumber, versionNumber, entryDataEntries );
    }

    private ImmutableCollection<Entry> readAllEntries(final byte[] data,
            final DataInputStream stream, final short numberOfEnties)
            throws IOException {
        Builder<Entry> builder = ImmutableList.builder();
        for ( int i = 0; i < numberOfEnties; i++ ) {
            final EntryId id = readEntryId(stream);
            final int offset = readEntryOffset(stream);
            final int length = readEntryLength(stream);
            
            
            builder.add( Entry.from( id, length, copyWithLimitCheck(data, offset, length) ) );
        }
        return builder.build();
    }

    private @Nonnull byte[] copyWithLimitCheck(byte[] data, int offset,
            int length) {
        if ( offset > 0 && length > 0 ) {
            if ( offset + length <= data.length ) {
                return Arrays.copyOfRange(data, offset, offset + length);
            }
        }
        
        return new byte[0];
    }

    private int readEntryLength(DataInputStream inStream) throws IOException {
        return inStream.readInt();
    }

    private int readEntryOffset(DataInputStream inStream) throws IOException {
        return inStream.readInt();
    }

    private EntryId readEntryId(DataInputStream inStream) throws IOException {
        return EntryId.fromInt( inStream.readInt() );
    }

    private short readNumberOfEntries(DataInputStream inStream) throws IOException {
        return inStream.readShort();
    }

    private String readHomeFileSysstem(DataInputStream inStream) throws IOException {
        // in the newer def this is just "filling" of 16 empty bytes
        final byte[] homeFileSystem = new byte[16];
        inStream.readFully(homeFileSystem);
        return Utils.stringFromAsciiBytes(homeFileSystem);
    }

    private int readVersionNumber(DataInputStream inStream) throws IOException {
        return inStream.readInt();
    }

    private int readMagicNumber(DataInputStream inStream) throws IOException {
        return inStream.readInt();
    }

}
