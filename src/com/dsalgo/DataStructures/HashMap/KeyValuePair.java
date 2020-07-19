package DataStructures.HashMap;

public class KeyValuePair {
    private final String key;
    private int value;
    private final int hashCode;

    public KeyValuePair(String key, int value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
