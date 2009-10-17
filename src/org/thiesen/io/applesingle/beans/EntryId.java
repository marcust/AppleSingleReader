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
package org.thiesen.io.applesingle.beans;

import javax.annotation.Nonnull;

import org.thiesen.io.applesingle.beans.converter.AsciiDataToStringConverter;
import org.thiesen.io.applesingle.beans.converter.EntryDataToStringConverter;
import org.thiesen.io.applesingle.beans.converter.ToEmptyStringConverter;

public enum EntryId {
    DATA_FORK(1, "Data Fork", new ToEmptyStringConverter()),
    RESOURCE_FORK(2, "Resource Fork", new ToEmptyStringConverter()),
    REAL_NAME(3, "File's name as created on home file system", new AsciiDataToStringConverter()),
    COMMENT(4, "Standard Macintosh comment", new AsciiDataToStringConverter()),
    ICON_BW(5, "Standard Macintosh black and white icon", new ToEmptyStringConverter()),
    ICON_COLOR(6, "Macintosh colour icon", new ToEmptyStringConverter()),
    FILE_INFO(7, "File info", new AsciiDataToStringConverter()),
    FILE_DATES_INFO(8, "File creation date, modification date, and so on", new ToEmptyStringConverter()),
    FINDER_INFO(9,"Standard Macintosh Finder information", new ToEmptyStringConverter()),
    MACINTOSH_FILE_INFO(10, "Macintosh file information, attributes and so on", new ToEmptyStringConverter()),
    PRO_DOS_FILE_INFO(11, "ProDOS file information, attributes and so on", new ToEmptyStringConverter()),
    MS_DOS_FILE_INFO(12, "MS-DOS file information, attributes and so on", new ToEmptyStringConverter()),
    SHORT_NAME(13, "AFP short name", new ToEmptyStringConverter()),
    AFP_FILE_INFO(14, "AFP file, information, attributes and so on", new ToEmptyStringConverter()),
    DIRECTORY_ID(15, "AFP directory ID", new ToEmptyStringConverter());
    
    private final int _id;
    private final String _description;
    private final EntryDataToStringConverter _converter;
    
    private EntryId( int id, String description, final EntryDataToStringConverter toStringConverter ) {
        _id = id;
        _description = description;
        _converter = toStringConverter;
    }

    public static EntryId fromInt(int intValue) {
        for ( final EntryId id : values() ) {
            if ( id.getId() == intValue ) {
                return id;
            }
        }
        return null;
    }

    private int getId() {
        return _id;
    }

    public @Nonnull String getDescription() {
        return _description;
    }

    public @Nonnull EntryDataToStringConverter getConverter() {
        return _converter;
    }
}