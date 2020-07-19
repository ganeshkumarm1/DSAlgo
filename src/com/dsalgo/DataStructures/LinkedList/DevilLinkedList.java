package DataStructures.LinkedList;


public class DevilLinkedList {
    private final Node root;
    
    public DevilLinkedList() {
        this.root = new Node(0);
    }


    public int get(int index) throws IndexOutOfBoundsException {
        int currIndex = 0;
        Node curr = root.getNext();

        if(index > this.size() - 1) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, this.size()));
        }

        while(curr != null) {
            if(currIndex == index) {
                return curr.getValue();
            }

            currIndex ++;
            curr = curr.getNext();
        }

        return -1;
    }

    public void add(int value) {
        Node node = new Node(value);

        Node curr = root;

        while (curr.getNext() != null) {
            curr = curr.getNext();
        }

        curr.setNext(node);
        root.setValue(root.getValue() + 1);
    }

    public void add(int index, int value) throws IndexOutOfBoundsException {
        int currIndex = 0;
        Node curr = root;

        if(index != 0 && index > this.size() - 1) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, this.size()));
        }

        while (curr != null) {
            if(index == currIndex) {
                Node node = new Node(value);
                node.setNext(curr.getNext());
                curr.setNext(node);
                root.setValue(root.getValue() + 1);
            }

            currIndex ++;
            curr = curr.getNext();
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        int currIndex = 0;
        Node curr = root.getNext();
        Node prev = root;

        if(index > this.size() - 1) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, this.size()));
        }

        while (curr != null) {
            if(index == currIndex) {
                if(currIndex == this.size() - 1) {
                    prev.setNext(null);
                }
                else {
                    if(curr.getNext() != null) {
                        curr.setValue(curr.getNext().getValue());
                        curr.setNext(curr.getNext().getNext());
                    }
                }

            }

            currIndex ++;
            prev = curr;
            curr = curr.getNext();
            root.setValue(root.getValue() - 1);
        }
    }

    public boolean contains(int value) {
        Node start = root.getNext();

        while (start != null) {
            if(start.getValue() == value) {
                return true;
            }

            start = start.getNext();
        }

        return false;
    }

    public int indexOf(int value) {
        Node start = root.getNext();

        int index = 0;
        while (start != null) {
            if(start.getValue() == value) {
                return index;
            }
            index ++;
            start = start.getNext();
        }

        return -1;
    }

    public int lastIndexOf(int value) {
        Node start = root.getNext();

        int result = -1;
        int index = 0;

        while (start != null) {
            if(start.getValue() == value) {
                result = index;
            }

            index ++;
            start = start.getNext();
        }

        return result;
    }

    public int size() {
        return root.getValue();
    }

    public boolean isEmpty() {
        return root.getValue() == 0;
    }

    public void clear() {
        root.setValue(0);
        root.setNext(null);
    }

    @Override
    public String toString() {
        Node curr = root.getNext();
        StringBuilder stringBuilder = new StringBuilder();

        while(curr != null) {
            stringBuilder.append(curr.getValue())
                    .append("\n");
            curr = curr.getNext();
        }

        return stringBuilder.toString();
    }
}
