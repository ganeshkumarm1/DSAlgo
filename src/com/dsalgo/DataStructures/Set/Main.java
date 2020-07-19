package DataStructures.Set;

/*
 * Created by GaNeShKuMaRm
 * Created at 23-Jun-20, 5:35 PM
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DevilSet s1 = new DevilSet();
        DevilSet s2 = new DevilSet();

        s1.add(1);
        s1.add(2);
        s1.add(3);

        s2.add(1);
        s2.add(2);
        s2.add(4);

        s2.remove(4);

        System.out.println(s1.equals(s2));
        System.out.println(Arrays.toString(s2.toArray()));

        s2.clear();

        System.out.println(s2.size());
    }
}
