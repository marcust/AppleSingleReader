package org.thiesen.io.applesingle.beans.converter;

public class ToEmptyStringConverter implements EntryDataToStringConverter {

    @Override
    public String fromBytes( final @SuppressWarnings( "unused" ) byte[] data) {
        return "";
    }

}
