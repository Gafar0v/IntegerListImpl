package org.gafarov;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerLinkedListTest {
    private IntegerList list;
    private IntegerList emptyList;

    @BeforeEach
    void init() {
        list = new IntegerLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        emptyList = new IntegerLinkedList();
    }

    @Test
    @DisplayName("size() returns correct size when not empty list provided")
    public void size_WhenNotEmptyListProvided_ThenCorrectSize() {
        assertEquals(9, list.size());
    }

    @Test
    @DisplayName("size() returns correct size when empty list provided")
    public void size_WhenEmptyListProvided_ThenCorrectSize() {
        assertEquals(0, emptyList.size());
    }

    @Test
    @DisplayName("isEmpty() return false when not empty list provided")
    public void isEmpty_WhenNotEmptyListProvided_ThenNotEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("isEmpty() return true when empty list provided")
    public void isEmpty_WhenEmptyListProvided_ThenEmpty() {
        assertTrue(emptyList.isEmpty());
    }

    @Test
    @DisplayName("contains() return false when empty list provided")
    public void contains_WhenEmptyListProvided_ThenFalse() {
        assertFalse(emptyList.contains(0));
    }

    @Test
    @DisplayName("contains() return true when not empty list provided and list contains this elem")
    public void contains_WhenListContainThisElem_ThenTrue() {
        assertTrue(list.contains(1));
    }

    @Test
    @DisplayName("contains() throw ClassCastException when cant convert object to Integer")
    public void contains_WhenStringElemProvided_ThenClassCastException() {
        assertThrows(ClassCastException.class, () -> {
            list.contains("one");
        });
    }


    @Test
    @DisplayName("get() return correct elem when not empty list provided")
    public void get_WhenNotEmptyListProvided_ThenCorrectElem() {
        assertEquals(3, list.get(2));
    }

    @Test
    @DisplayName("get() return IndexOutOfBoundsException when empty list provided ")
    public void get_WhenEmptyListProvided_ThenIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            emptyList.get(2);
        });
    }

    @Test
    @DisplayName("get() return IndexOutOfBoundsException when the index is out of range")
    public void get_WhenProvidedIndexIsOutOfRangeInList_ThenIndexOutOfBoundException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(15);
        });
    }

    @Test
    @DisplayName("add() return IndexOutOfBoundsException when empty list provided")
    public void add_WhenEmptyListProvided_ThenIndexOutOfBoundException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            emptyList.add(0, 10);
        });
    }

    @Test
    @DisplayName("add() change elem by index when not emty list provided")
    public void add_WhenNotEmptyListProvided_ThenCorrectResult() {
        list.add(5, 10);
        assertEquals(10, list.get(5));
    }

    @Test
    @DisplayName("add() return IndexOutOfBoundsException when index is out of range")
    public void add_WhenProvidedIndexIsOutOfRange_ThenIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(100, 10);
        });
    }

    @Test
    @DisplayName("remove() return IndexOutOfBoundsException when empty list provided")
    public void removeByIndex_WhenEmptyListProvided_ThenIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            emptyList.remove(10);
        });
    }

    @Test
    @DisplayName("remove() return removed elem when not empty list provided")
    public void removeByIndex_WhenNotEmptyListProvided_ThenRemovedElem() {
        assertEquals(3, list.remove(2));
    }

    @Test
    @DisplayName("remove() return IndexOutOfBoundsException when index is out of range in list")
    public void removeByIndex_WhenProvidedIndexIsOutOfRange_ThenIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @Test
    @DisplayName("indexOf() return -1 when list dont have elem")
    public void indexOf_EmptyListProvided() {
        assertEquals(-1, emptyList.indexOf(10));
    }

    @Test
    @DisplayName("indexOf() return index of element when provided list have this element")
    public void indexOf_WhenNotEmptyList_ThenCorrectIndex() {
        assertEquals(3, list.indexOf(4));
    }

    @Test
    @DisplayName("add() append element to empty list")
    public void addToEnd_WhenEmptyList_ThenAppendElem() {
        emptyList.add(1);
        assertEquals(1, emptyList.get(0));
    }

    @Test
    @DisplayName("add() append element to list")
    public void addToEnd_WhenNotEmptyList_ThenAppendElem() {
        list.add(10);
        assertEquals(10, list.get(9));
    }


    @Test
    @DisplayName("remove() return false when provided list dont have this elem")
    public void removeElem_WhenEmtpyListProvided_ThenFalse() {
        Integer i = 1;
        boolean isRemoved = emptyList.remove(i);
        assertFalse(isRemoved);
    }

    @Test
    @DisplayName("remove() return true and remove elem when provided list have this elem")
    public void removeElem_WhenNotEmtpyListProvided_ThenTrue() {
        Integer i = 1;
        boolean isRemoved = list.remove(i);
        assertTrue(isRemoved);
    }
}