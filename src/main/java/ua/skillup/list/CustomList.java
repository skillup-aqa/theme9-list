package ua.skillup.list;

import java.util.NoSuchElementException;

public class CustomList implements ICustomList {
    private Node head;

    private int size = 0;

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
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node current = head;
        Node prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }

        size--;
        return current.value;
    }

    @Override
    public Object shift() {
        if (size == 0) {
            throw new NoSuchElementException();
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
            throw new IndexOutOfBoundsException();
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
            if (current.value.equals(obj)) {
                return i;
            }

            current = current.next;
            i++;
        }

        return -1;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return shift();
        }

        Node current = head;
        Node prev = null;
        int i = 0;

        while (current != null) {
            if (index == i) {
                prev.next = current.next;
                size--;
                return current.value;
            }

            prev = current;
            current = current.next;
            i++;
        }

        return null;
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
