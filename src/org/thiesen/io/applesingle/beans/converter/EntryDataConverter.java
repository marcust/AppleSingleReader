package org.thiesen.io.applesingle.beans.converter;

public interface EntryDataConverter<T> {

    public T fromBytes(byte[] data);
    
}
