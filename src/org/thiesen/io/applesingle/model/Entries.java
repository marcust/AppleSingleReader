package org.thiesen.io.applesingle.model;

import com.google.common.collect.ImmutableCollection;

public class Entries {

    private final ImmutableCollection<Entry> _entries;
    
    private Entries(final ImmutableCollection<Entry> entries) {
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
    
    
    
}
