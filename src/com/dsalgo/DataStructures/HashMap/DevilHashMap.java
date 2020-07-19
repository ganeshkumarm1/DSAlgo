package DataStructures.HashMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DevilHashMap {
    private final List<LinkedList<KeyValuePair>> buckets = new ArrayList<>();
    private static final int maxBucketSize = 26;

    {
        for(int i = 0; i < 26; i ++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int generateHashCode(String key) {
        if(key == null) return 0;
        return ((int) key.charAt(0)) & (maxBucketSize - 1);
    }

    private boolean equals(String keyInLinkedList, String incomingKey) {
        return Objects.equals(keyInLinkedList, incomingKey);
    }


    KeyValuePair findKeyValuePair(String key) {
        int hashCode = this.generateHashCode(key);
        LinkedList<KeyValuePair> linkedList = buckets.get(hashCode);
        for (KeyValuePair keyValuePair : linkedList) {
            if (this.equals(keyValuePair.getKey(), key)) {
                return keyValuePair;
            }
        }

        return null;
    }

    private void addToLinkedList(String key, int value) {
        int hashCode = this.generateHashCode(key);
        LinkedList<KeyValuePair> linkedList = buckets.get(hashCode);
        KeyValuePair newKeyValuePair = new KeyValuePair(key, value, hashCode);
        linkedList.add(newKeyValuePair);
    }

    public void put(String key, int value) {

        KeyValuePair keyValuePair = this.findKeyValuePair(key);
        if(keyValuePair != null) {
            keyValuePair.setValue(value);
            return;
        }

        this.addToLinkedList(key, value);
    }

    public Integer get(String key) {
        KeyValuePair keyValuePair = this.findKeyValuePair(key);

        if(keyValuePair != null) {
            return keyValuePair.getValue();
        }

        return null;
    }

    public boolean hasKey(String key) {
        int hashCode = this.generateHashCode(key);
        LinkedList<KeyValuePair> linkedList = buckets.get(hashCode);

        for(KeyValuePair keyValuePair: linkedList) {
            if(this.equals(keyValuePair.getKey(), key)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasValue(int value) {
        for (LinkedList<KeyValuePair> linkedList : buckets) {
            for(KeyValuePair keyValuePair: linkedList) {
                if(keyValuePair.getValue() == value) {
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (LinkedList<KeyValuePair> linkedList : buckets) {
            for(KeyValuePair keyValuePair: linkedList) {
                stringBuilder.append(keyValuePair.getKey())
                        .append(" : ")
                        .append(keyValuePair.getValue())
                        .append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
