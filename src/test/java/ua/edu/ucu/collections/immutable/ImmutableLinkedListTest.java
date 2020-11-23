package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {


    public void testListValueAppend(ImmutableLinkedList arrayList, Object e, Object[] expected) {
        ImmutableLinkedList newArrayList;
        newArrayList = (ImmutableLinkedList) arrayList.add(e);
        Object[] expectedValue = expected;
        Object[] realValue = newArrayList.toArray();

//        printArray(realValue);
//        printArray(expectedValue);

        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    public void testListValueInsert(ImmutableLinkedList arrayList, Object e, int index, Object[] expected) {
        ImmutableLinkedList newArrayList;
        newArrayList = (ImmutableLinkedList) arrayList.add(index, e);
        Object[] expectedValue = expected;
        Object[] realValue = newArrayList.toArray();

//        printArray(realValue);
//        printArray(expectedValue);

        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    // add testing
    @Test
    public void testArrayListAddOneElem() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList();

        int element = 8;
        Object[] expectedValue = {8};
        testListValueAppend(list01, element, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01, arr01.length);
        int element = 8;
        Object[] expectedValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8};
        testListValueAppend(list01, element, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem02() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01, arr01.length);
        int element = 8;
        Object[] expectedValue = {8, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        testListValueInsert(list01, element, 0, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem03() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01, arr01.length);
        int element = 8;
        Object[] expectedValue = {1, 8, 2, 3, 4, 5, 6, 7, 8, 9};
        testListValueInsert(list01, element, 1, expectedValue);
    }
//
//    @Test
//    public void testArrayListAddOneElem2() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        ImmutableArrayList list01 = new ImmutableArrayList(arr01);
//        Object element = null;
//        Object[] expectedValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, null};
//        testListValueAdd(list01, arr01, element, -1, expectedValue);
//    }
//
//    @Test
//    public void testArrayListAddOneElem3() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        ImmutableArrayList list01 = new ImmutableArrayList(arr01);
//        int element = 7;
//        Object[] expectedValue = {7, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        testListValueAdd(list01, arr01, element, 0, expectedValue);
//    }
//
//    // addAll testing
//    @Test
//    public void testArrayListAddObjList() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Object[] arr02 = new Object[]{1, 1, 1, 1};
//        Object[] expectedValue = new Object[]{1, 2, 3, 1, 1, 1, 1, 4, 5, 6, 7, 8, 9};
//        TestArrayListObjListAdd(arr01, arr02, 3, expectedValue);
//    }
//
//    @Test
//    public void testArrayListAddObjList2() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Object[] arr02 = new Object[]{};
//        Object[] expectedValue = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        TestArrayListObjListAdd(arr01, arr02, 3, expectedValue);
//    }
//
//    @Test
//    public void testArrayListAppendObjList() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Object[] arr02 = new Object[]{133};
//        Object[] expectedValue = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 133};
//        TestArrayListObjListAdd(arr01, arr02, -1, expectedValue);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void testArrayListOutOfBounds() {
//        Object[] arr01 = new Object[]{};
//        Object[] arr02 = new Object[]{};
//        Object[] expectedValue = new Object[]{};
//        TestArrayListObjListAdd(arr01, arr02, 9, expectedValue);
//    }
//
//    @Test
//    public void testArrayGetN01() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int index = 2;
//        Object expectedValue = 3;
//        TestArrayGet(arr01, index, expectedValue);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void testArrayGetN02() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int index = 200;
//        Object expectedValue = null;
//        TestArrayGet(arr01, index, expectedValue);
//    }
//
//    @Test
//    public void testArraySetN01() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int index = 0;
//        Object value = 77;
//        Object expectedValue = 77;
//        TestArraySet(arr01, index, value, expectedValue);
//    }
//
//    @Test
//    public void testArrayRemoveN01() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int index = 1;
//        Object expectedValue = 3;
//        TestArrayRemove(arr01, index, expectedValue);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void testArrayRemoveN02() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int index = 22;
//        Object expectedValue = 3;
//        TestArrayRemove(arr01, index, expectedValue);
//    }
//
//    @Test
//    public void testArrayIndexOfN01() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Object value = 9;
//        int expectedValue = 8;
//        TestArrayIndexOf(arr01, value, expectedValue);
//    }
//
//    @Test
//    public void testArrayIndexOfN02() {
//        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Object value = 0;
//        int expectedValue = -1;
//        TestArrayIndexOf(arr01, value, expectedValue);
//    }

    public void printArray(Object[] arr) {
        System.out.println("---------");
        for (Object o : arr) {
            System.out.println(o);
        }
        System.out.println("---------");
    }
}
