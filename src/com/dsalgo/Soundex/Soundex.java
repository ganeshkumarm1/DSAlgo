package Soundex;

import java.util.HashMap;
import java.util.Map;

public class Soundex {
    private final static Map<String, Character> values =
            Map.of( "AEIOUHWY", '.',
                    "BFPV", '1',
                    "CGJKQSXZ", '2',
                    "DT", '3',
                    "L", '4',
                    "MN", '5',
                    "R", '6'
            );

    public String getSoundex(String name) {
        name = name.toUpperCase();

        StringBuilder soundex = new StringBuilder();
        soundex.append(name.charAt(0));

        for(int i = 1; i < name.length(); i ++) {
            char c = name.charAt(i);


            for(Map.Entry<String, Character> entry: values.entrySet()) {
                String key = entry.getKey();
                if(key.indexOf(c) >= 0) {
                    if(soundex.charAt(soundex.length() - 1) != c) {
                        soundex.append(values.get(key));
                    }
                }
            }
        }

        return soundex.append("0000")
                .toString()
                .replace(".", "")
                .substring(0, 4);
    }
}
