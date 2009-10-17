package org.thiesen.io.applesingle.model;

import java.io.InputStream;

import javax.annotation.CheckForNull;

import org.thiesen.io.applesingle.beans.EntryId;

import com.google.common.collect.ImmutableCollection;

public class Entries {

    private final Iterable<Entry> _entries;
    
    private Entries(final Iterable<Entry> entries) {
        _entries = entries;
    }
    
    public static Entries wrap(ImmutableCollection<Entry> entries) {
        return new Entries(entries);
    }

    public void appendTo(StringBuilder retval) {
        for ( final Entry e : _entries ) {
            retval.append("\tEntry: ").append(e.toString()).append('\n');
        }
    }

    public InputStream getResourceForkStream() {
        final Entry resourceForkEntry = getEntryById(EntryId.RESOURCE_FORK);
        if ( resourceForkEntry != null ) {
            return resourceForkEntry.dataAsNewStream();
        }
        
        return null;
    }

    public String getRealName() {
        final Entry realNameEntry = getEntryById(EntryId.REAL_NAME);
        
        if (realNameEntry != null) {
            return realNameEntry.convertedStringValue();
        }
        return null;
    }
    
    private @CheckForNull Entry getEntryById( final EntryId id ) {
        for ( final Entry e :  _entries ) {
            if ( e.getId() == id ) {
                return e;
            }
        }
        return null;
    }
    
}
