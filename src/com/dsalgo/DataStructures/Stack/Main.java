package DataStructures.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        DevilStack s1 = new DevilStack();

        s1.push(1);
        s1.push(2);
        s1.push(2);
        s1.push(2);
        s1.push(2);
        s1.push(2);
        s1.push(2);
        s1.push(2);
        s1.push(2);
        s1.push(10);
        s1.push(12);
        s1.peek();
        s1.pop();
        s1.print();

    }
}
