package ua.skillup.list;

public class CustomList implements ICustomList {

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    private int size = 0;

    private Node head;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void push(Object obj) {
        if (head == null) {
            head = new Node(obj);
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(obj);
        size++;

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object shift() {
        return null;
    }

    @Override
    public void unshift(Object obj) {

    }

    @Override
    public void insert(int index, Object obj) {

    }

    @Override
    public int indexOf(Object obj) {
        return 0;
    }

    @Override
    public Object remove(int index) {
        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "This is an empty list";
        } else {

            StringBuilder builder = new StringBuilder("Orders List: \n");

            Node current = head;
            do {
                builder.append(current.value.toString()+"\n");
                current = current.next;
            } while (current != null);

            return builder.toString();
        }
    }
}



