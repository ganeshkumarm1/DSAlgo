package DataStructures.HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        DevilHashMap hashMap = new DevilHashMap();

        hashMap.put("Dhoni", 1);
        hashMap.put("Kohli", 2);
        hashMap.put("Rohit", 3);
        hashMap.put("Dhoni", 5);
        hashMap.put(null, 9);

        DevilHashMap hashMap1 = new DevilHashMap();

        System.out.println(hashMap1.get("Dhoni"));


        System.out.println(hashMap.hasKey("Dhoniad"));
        System.out.println(hashMap.hasKey("Dhoni"));
        System.out.println("----------");
        System.out.println(hashMap.hasValue(5));
        System.out.println(hashMap.hasValue(100));

       // System.out.println(hashMap.toString());


        List<Integer> x = new ArrayList<>();

        //LinkedList

        Set<Integer> s = new HashSet<>();
        Set<Integer> s1 = new HashSet<>();
        System.out.println(s.equals(s1));
        s.toArray();
    }
}
