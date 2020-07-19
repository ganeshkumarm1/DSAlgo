package DataStructures.LinkedList;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> linkedList = new LinkedList<>();
        DevilLinkedList devilLinkedList = new DevilLinkedList();


        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);


        devilLinkedList.add(1);
        devilLinkedList.add(2);
        devilLinkedList.add(3);


        System.out.println(devilLinkedList.toString());

        for (int i = 0; i < devilLinkedList.size(); i++) {
            System.out.println(devilLinkedList.get(i));
        }
    }
}
