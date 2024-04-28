package ua.skillup.list;

//This is directional cyclic, should be rewritten to unidirectional cyclic (25 % 4 + 1 = 2)

import java.util.NoSuchElementException;

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
        if (head == null) {
            throw new NoSuchElementException("There is an empty list. Pop can't be applied");
        }
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = null;
        } else {
            previous.next = null;
        }
        size--;


        return current.value;
    }

    @Override
    public Object shift() {
        if (head == null) {
            throw new NoSuchElementException("There is an empty list. Shift can't be applied");
        }
        Node current = head;
        head = head.next;
        size--;
        return current.value;
    }

    @Override
    public void unshift(Object obj) {
        Node newHead = new Node(obj);
        newHead.next = head;
        head = newHead;
        size++;
    }

    @Override
    public void insert(int index, Object obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is incorrect");
        }
        if (index == 0) {
            unshift(obj);
            return;
        }

        Node current = head;
        Node prev = null;
        int i = 0;

        while (current != null) {
            if (index == i) {
                Node newNode = new Node(obj);
                prev.next = newNode;
                newNode.next = current;
                size++;
                return;
            }
            prev = current;
            current = current.next;
            i++;

        }

    }

    @Override
    public int indexOf(Object obj) {
        Node current = head;
        int i = 0;

        while (current != null) {
            if (current.value == obj) {
                return i;
            }

            current = current.next;
            i++;
        }

        return -1;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index is incorrect");
        }
        Node previous = null;
        Node current = head;
        int i = 0;

        while (current != null) {

            if (index == i) {
                previous.next = current.next;
                size--;
                return current.value;
            }

            previous = current;
            current = current.next;
            i++;
        }

        return null;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "This is an empty list";
        } else {

            StringBuilder builder = new StringBuilder("Orders List: \n");

            Node current = head;
            do {
                builder.append(current.value.toString() + "\n");
                current = current.next;
            } while (current != null);
            builder.append("Size of the list is: ").append(size()).append("\n");

            return builder.toString();
        }
    }
}



