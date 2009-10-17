package org.thiesen.io.applesingle.model;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableCollection;

public class AppleSingle {

    private final MagicNumber _magicNumber;
    private final VersionNumber _versionNumber;
    private final Entries _entries;

    private AppleSingle( @Nonnull MagicNumber magicNumber, @Nonnull VersionNumber versionNumber, @Nonnull  Entries entries) {
        _magicNumber = magicNumber;
        _versionNumber = versionNumber;
        _entries = entries;
    }

    public static AppleSingle fromRawData(int magicNumber, int versionNumber,
            ImmutableCollection<Entry> entryDataEntries) {
        return new AppleSingle( MagicNumber.valueOf(magicNumber), VersionNumber.valueOf( versionNumber ), 
                Entries.wrap( entryDataEntries ) ); 
    }

    @Override
    public String toString() {
        final StringBuilder retval = new StringBuilder();
        
        retval.append("AppleSingle ").append(_magicNumber).append(" ").append(_versionNumber).append('\n');
        _entries.appendTo(retval);
        return retval.toString();
    }
    
}
