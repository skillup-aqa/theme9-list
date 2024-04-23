package ua.skillup.list;

import java.util.NoSuchElementException;

public interface ICustomList {
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    Object get(int index);

    /**
     * Adds the specified element to the end of this list.
     *
     * @param obj element to be appended to this list
     */
    void push(Object obj);

    /**
     * Removes the element at the end of this list.
     * @return the element removed from the end of this list
     * @throws NoSuchElementException if this list is empty
     */
    Object pop();

    /**
     * Removes the element at the beginning of this list.
     * @return the element removed from the beginning of this list
     * @throws NoSuchElementException if this list is empty
     */
    Object shift();

    /**
     * Adds the specified element to the beginning of this list.
     *
     * @param obj element to be appended to this list
     */
    void unshift(Object obj);

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param obj   element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void insert(int index, Object obj);

    /**
     * Returns index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     *
     * @param obj element to search for
     * @return index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(Object obj);

    /**
     * Removes the element by index from this list, if present.
     *
     * @param index element to be removed from this list, if present
     * @return the element removed from this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    Object remove(int index);

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    String toString();
}
