/*
 * $Id$
 * (c) Copyright 2009 freiheit.com technologies GmbH
 *
 * Created on 17.10.2009 by Marcus Thiesen (marcus@freiheit.com)
 *
 * This file contains unpublished, proprietary trade secret information of
 * freiheit.com technologies GmbH. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * freiheit.com technologies GmbH.
 */
package org.thiesen.io.applesingle.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import org.thiesen.io.applesingle.beans.EntryId;

public class Entry {
    private final EntryId _id;
    private final int _length;
    private final byte[] _data;
    
    private Entry( final EntryId id, final int length, final byte[] data ) {
        super();
        _id = id;
        _length = length;
        _data = data;
    }

    public static Entry from( final EntryId id, final int length, byte[] data) {
        return new Entry( id, length, data );
    }
    
    public @Nonnull InputStream dataAsNewStream() {
        return new ByteArrayInputStream(_data);
    }
    
    public @CheckForNull byte[] getBytes() {
        return _data.clone();
    }
    
    public @Nonnull String toString() {
        return _id + " (length: " + _length + ")";
    }
    
}