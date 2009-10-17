package org.thiesen.io.applesingle.model;

public class VersionNumber extends Number {

    private static final long serialVersionUID = -8959131725429312676L;
    private final Integer _value;

    private VersionNumber( final Integer versionNumber ) {
        _value = versionNumber;
    }
    
    @Override
    public byte byteValue() {
        return _value.byteValue();
    }

    public int compareTo(Integer anotherInteger) {
        return _value.compareTo(anotherInteger);
    }

    @Override
    public double doubleValue() {
        return _value.doubleValue();
    }

    @Override
    public float floatValue() {
        return _value.floatValue();
    }

    @Override
    public int intValue() {
        return _value.intValue();
    }

    @Override
    public long longValue() {
        return _value.longValue();
    }

    @Override
    public short shortValue() {
        return _value.shortValue();
    }

    @Override
    public String toString() {
        return "Version: " + Integer.toHexString(_value.intValue());
    }

    public static VersionNumber valueOf(int versionNumber) {
        return new VersionNumber(Integer.valueOf(versionNumber));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_value == null) ? 0 : _value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VersionNumber other = (VersionNumber) obj;
        if (_value == null) {
            if (other._value != null)
                return false;
        } else if (!_value.equals(other._value))
            return false;
        return true;
    }

}
