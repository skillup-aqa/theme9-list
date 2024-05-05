package ua.skillup.list;

//directional cyclic (25 % 4 + 1 = 2)

import java.util.NoSuchElementException;

public class CustomList implements ICustomList {

    private static class Node {
        //refactored for directional cyclic
        Object value;
        Node next;
        Node first;

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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        int i = 0;

        while (current != null) {
            if (index == i) {
                return current.value;
            }
            i++;
            current = current.next;
        }

        return null;
    }


    @Override
    public void push(Object obj) {
        //refactored for directional cyclic
        if (head == null) {
            head = new Node(obj);
            head.first = new Node(obj);
            head.next = head.first;
            size++;
            return;
        }

        Node current = head;
        if (size == 1) {
            current.next = new Node(obj);
            current = current.next;
            current.next = head.first;
            size++;
            return;
        }

        while (current.next != head.first) {
            current = current.next;
        }
        current.next = new Node(obj);
        current.next.next = head.first;
        size++;
    }


    @Override
    public Object pop() {
        //refactored for directional cyclic
        if (head == null) {
            throw new NoSuchElementException("There is an empty list. Pop can't be applied");
        }
        Node current = head;
        Node previous = null;
        while (current.next != head.first) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = null;
        } else {
            previous.next = head.first;
        }
        size--;


        return current.value;
    }

    @Override
    public Object shift() {
        //refactored for directional cyclic
        if (head == null) {
            throw new NoSuchElementException("There is an empty list. Shift can't be applied");
        }
        Node current = head;
        head = head.next;
        head.first = head;
        size--;
        return current.value;
    }

    @Override
    public void unshift(Object obj) {
        Node newHead = new Node(obj);
        newHead.next = head;
        head = newHead;
        head.first = new Node(obj);
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
            for (int i = 0; i <size; i++) {
                builder.append(current.value.toString() + "\n");
                current = current.next;
            }
            builder.append("Size of the list is: ").append(size()).append("; First value " + head.first.value).append("\n");

            return builder.toString();
        }
    }
}



