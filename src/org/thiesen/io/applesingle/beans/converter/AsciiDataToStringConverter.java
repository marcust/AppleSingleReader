package org.thiesen.io.applesingle.beans.converter;

import org.thiesen.io.applesingle.util.Utils;

public class AsciiDataToStringConverter implements EntryDataToStringConverter {

    @Override
    public String fromBytes(byte[] data) {
        return Utils.stringFromAsciiBytes(data);
    }

}
