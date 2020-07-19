package DataStructures.Stack;

import java.util.ArrayList;
import java.util.List;

public class DevilStack {
    private final List<Integer> values;
    private static final int maxSize = 10;

    public DevilStack() {
        this.values = new ArrayList<>();
    }

    public void push(int value) throws FullDevilStackException {
        if(this.isFull()) {
            throw new FullDevilStackException("Stack is full");
        }

        if(!this.isFull()) {
            values.add(value);
        }
    }

    public int pop() throws EmptyDevilStackException {
        if(this.isEmpty()) {
            throw new EmptyDevilStackException("Stack is empty");
        }

        int lastIndex = values.size() - 1;
        int value = values.get(lastIndex);
        values.remove(lastIndex);

        return value;
    }

    public int peek() throws EmptyDevilStackException {
        if(this.isEmpty()) {
            throw new EmptyDevilStackException("Stack in empty");
        }

        return values.get(values.size() - 1);
    }

    public boolean isEmpty() {
        return values.size() == 0;
    }

    public boolean isFull() {
        return  values.size() == maxSize;
    }

    public void print() {
        if(this.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for(Integer value: values) {
            System.out.println(value);
        }
    }
}
