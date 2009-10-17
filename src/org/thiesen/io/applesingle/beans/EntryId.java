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

public enum EntryId {
    DATA_FORK(1, "Data Fork"),
    RESOURCE_FORK(2, "Resource Fork"),
    REAL_NAME(3, "File's name as created on home file system"),
    COMMENT(4, "Standard Macintosh comment"),
    ICON_BW(5, "Standard Macintosh black and white icon"),
    ICON_COLOR(6, "Macintosh colour icon"),
    FILE_INFO(7, "File info"),
    FILE_DATES_INFO(8, "File creation date, modification date, and so on"),
    FINDER_INFO(9,"Standard Macintosh Finder information"),
    MACINTOSH_FILE_INFO(10, "Macintosh file information, attributes and so on"),
    PRO_DOS_FILE_INFO(11, "ProDOS file information, attributes and so on"),
    MS_DOS_FILE_INFO(12, "MS-DOS file information, attributes and so on"),
    SHORT_NAME(13, "AFP short name"),
    AFP_FILE_INFO(14, "AFP file, information, attributes and so on"),
    DIRECTORY_ID(15, "AFP directory ID");
    
    private final int _id;
    private final String _description;

    private EntryId( int id, String description ) {
        _id = id;
        _description = description;
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

    public String getDescription() {
        return _description;
    }
}