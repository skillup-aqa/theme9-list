package ua.skillup.list;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class CustomListTests {

    CustomList emptyList;
    CustomList list;
    @BeforeMethod
    public void initEmptyList() {
        emptyList = new CustomList();
    }

    @BeforeMethod
    public void initList() {
        list = new CustomList();
        list.push("A");
        list.push("B");
        list.push("C");
    }

    @Test
    public void testSizeOfEmptyList() {
        assertEquals(emptyList.size(), 0);
    }

    @Test
    public void testPushAndGet() {
        emptyList.push("A");
        emptyList.push("B");
        emptyList.push("C");
        assertEquals(emptyList.size(), 3);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(emptyList.get(0), "A");
        sa.assertEquals(emptyList.get(1), "B");
        sa.assertEquals(emptyList.get(2), "C");
    }

    @Test
    public void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testPop() {
        String poped = (String) list.pop();
        assertEquals(poped, "C");
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "A");
        assertEquals(list.get(1), "B");

        poped = (String) list.pop();
        assertEquals(poped, "B");
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), "A");

        poped = (String) list.pop();
        assertEquals(poped, "A");
        assertEquals(list.size(), 0);
    }

    @Test
    public void testPopEmptyList() {
        assertThrows(NoSuchElementException.class, () -> emptyList.pop());
    }

    @Test
    public void testShift() {
        String shifted = (String) list.shift();
        assertEquals(shifted, "A");
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "B");
        assertEquals(list.get(1), "C");

        shifted = (String) list.shift();
        assertEquals(shifted, "B");
        assertEquals(list.size(), 1);
        assertEquals(list.get(0), "C");

        shifted = (String) list.shift();
        assertEquals(shifted, "C");
        assertEquals(list.size(), 0);
    }

    @Test
    public void testShiftEmptyList() {
        assertThrows(NoSuchElementException.class, () -> emptyList.shift());
    }

    @Test
    public void testUnshift() {
        list.unshift("D");
        assertEquals(list.size(), 4);
        assertEquals(list.get(0), "D");
        assertEquals(list.get(1), "A");
        assertEquals(list.get(2), "B");
        assertEquals(list.get(3), "C");
    }

    @Test
    public void testInsert() {
        list.insert(1, "D");
        assertEquals(list.size(), 4);
        assertEquals(list.get(0), "A");
        assertEquals(list.get(1), "D");
        assertEquals(list.get(2), "B");
        assertEquals(list.get(3), "C");
    }

    @Test
    public void testInsertAtTheBegging() {
        list.insert(0, "D");
        assertEquals(list.size(), 4);
        assertEquals(list.get(0), "D");
        assertEquals(list.get(1), "A");
        assertEquals(list.get(2), "B");
        assertEquals(list.get(3), "C");
    }

    @Test
    public void testInsertOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, "D"));
    }

    @Test
    public void testInsertOutOfBoundsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, "D"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(list.indexOf("A"), 0);
        assertEquals(list.indexOf("B"), 1);
        assertEquals(list.indexOf("C"), 2);
        assertEquals(list.indexOf("D"), -1);
    }

    @Test
    public void testRemove() {
        String removed = (String) list.remove(1);
        assertEquals(removed, "B");
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "A");
        assertEquals(list.get(1), "C");
    }

    @Test
    public void testRemoveFirst() {
        String removed = (String) list.remove(0);
        assertEquals(removed, "A");
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), "B");
        assertEquals(list.get(1), "C");
    }

    @Test
    public void testRemoveOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }
}
