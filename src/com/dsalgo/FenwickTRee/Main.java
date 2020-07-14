package FenwickTRee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        array.add(3); //0
        array.add(0); //1
        array.add(5); //2
        array.add(6); //3
        array.add(1); //4
        array.add(2); //5
        array.add(1); //6
        array.add(3); //7
        array.add(4); //8
        array.add(6); //9

        FenwickTree fenwickTree = new FenwickTree();

        fenwickTree.build(array);

        /*
           * Query based on 0 index
        */
        System.out.println("Before Update");
        System.out.println(fenwickTree.getSum(1 ,3));
        System.out.println(fenwickTree.getSum(4 ,7));
        System.out.println(fenwickTree.getSum(8 ,9));
        System.out.println(fenwickTree.getSum(1 ,6));

        /*
            * Here update means, replacing the current value with the new value
            * So, we have to pass the difference between new value and current value
        */
        fenwickTree.update(1, 3 - array.get(1));
        fenwickTree.update(4, 2 - array.get(4));

        System.out.println("After Update");
        System.out.println(fenwickTree.getSum(1 ,3));
        System.out.println(fenwickTree.getSum(4 ,7));
        System.out.println(fenwickTree.getSum(8 ,9));
        System.out.println(fenwickTree.getSum(1 ,6));


    }
}

//[0, 5, 5, 5, 16, 1, 3, 1, 23, 4, 10]
