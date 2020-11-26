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

        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    public void testListValueInsert(ImmutableLinkedList arrayList, Object e, int index, Object[] expected) {
        ImmutableLinkedList newArrayList;
        newArrayList = (ImmutableLinkedList) arrayList.add(index, e);
        Object[] expectedValue = expected;
        Object[] realValue = newArrayList.toArray();

        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    public void testListValueInsertMultiple(ImmutableLinkedList arrayList, Object[] e, int index, Object[] expected) {
        ImmutableLinkedList newArrayList;
        newArrayList = (ImmutableLinkedList) arrayList.addAll(index, e);
        Object[] expectedValue = expected;
        Object[] realValue = newArrayList.toArray();
        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    public void TestListGet(ImmutableLinkedList arrayList, int index, Object expected) throws IllegalAccessException {
        ImmutableLinkedList newArrayList;
        Object realValue = arrayList.get(index);
        Object expectedValue = expected;
        assertEquals(realValue, expectedValue);
    }

    public void TestListSet(ImmutableLinkedList arrayList, int index, Object value, Object expectedValue) throws IllegalAccessException {
        ImmutableLinkedList newArrayList;
        newArrayList = (ImmutableLinkedList) arrayList.set(index, value);
        Object realValue = newArrayList.get(index);
        assertEquals(realValue, expectedValue);
    }

    public void TestListRemove(ImmutableLinkedList arrayList, int index, Object expectedValue) throws IllegalAccessException {
        ImmutableLinkedList newArrayList;
        newArrayList = (ImmutableLinkedList) arrayList.remove(index);
        Object realValue = newArrayList.get(index);
        assertEquals(realValue, expectedValue);
    }

    public void TestListIndexOf(ImmutableLinkedList arrayList, Object value, int expectedValue) {
        int realValue = arrayList.indexOf(value);
        assertEquals(realValue, expectedValue);
    }

    // add testing
    @Test
    public void testArrayListAddOneElem() {
        ImmutableLinkedList list01 = new ImmutableLinkedList();
        int element = 8;
        Object[] expectedValue = {8};
        testListValueAppend(list01, element, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int element = 8;
        Object[] expectedValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8};
        testListValueAppend(list01, element, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem02() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int element = 8;
        Object[] expectedValue = {8, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        testListValueInsert(list01, element, 0, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem03() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int element = 8;
        Object[] expectedValue = {1, 8, 2, 3, 4, 5, 6, 7, 8, 9};
        testListValueInsert(list01, element, 1, expectedValue);
    }

    // addAll testing
    @Test
    public void testArrayListAppendList() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] arr02 = new Object[]{1, 1, 1, 1};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        Object[] expectedValue = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 1, 1};
        testListValueInsertMultiple(list01, arr02, -1, expectedValue);
    }

    @Test
    public void testArrayListAppendEmptyList() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] arr02 = new Object[]{};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        Object[] expectedValue = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        testListValueInsertMultiple(list01, arr02, -1, expectedValue);
    }

    @Test
    public void testArrayListInsertList() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] arr02 = new Object[]{1, 1, 1};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        Object[] expectedValue = new Object[]{1, 2, 1, 1, 1, 3, 4, 5, 6, 7, 8, 9};
        testListValueInsertMultiple(list01, arr02, 2, expectedValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayListOutOfBounds() {
        Object[] arr01 = new Object[]{};
        Object[] arr02 = new Object[]{};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        Object[] expectedValue = new Object[]{};
        testListValueInsertMultiple(list01, arr02, 2, expectedValue);
    }

    @Test
    public void testArrayGetN01() throws IllegalAccessException {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int index = 2;
        Object expectedValue = 3;
        TestListGet(list01, index, expectedValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayGetN02() throws IllegalAccessException {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int index = 200;
        Object expectedValue = null;
        TestListGet(list01, index, expectedValue);
    }

    @Test
    public void testArraySetN01() throws IllegalAccessException {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int index = 0;
        Object value = 77;
        Object expectedValue = 77;
        TestListSet(list01, index, value, expectedValue);
    }

    @Test
    public void testArrayRemoveN01() throws IllegalAccessException {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int index = 1;
        Object expectedValue = 3;
        TestListRemove(list01, index, expectedValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayRemoveN02() throws IllegalAccessException {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        int index = 22;
        Object expectedValue = 3;
        TestListRemove(list01, index, expectedValue);
    }

    @Test
    public void testArrayIndexOfN01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        Object value = 9;
        int expectedValue = 8;
        TestListIndexOf(list01, value, expectedValue);
    }

    @Test
    public void testArrayIndexOfN02() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableLinkedList list01 = new ImmutableLinkedList(arr01);
        Object value = 0;
        int expectedValue = -1;
        TestListIndexOf(list01, value, expectedValue);
    }

    @Test
    public void testToStringArray() {
        Object[] arr01 = new Object[]{1, 2, 3};
        String expectedValue = "[ 1 2 3 ]";
        ImmutableLinkedList arrayList = new ImmutableLinkedList(arr01);
        String realValue = arrayList.toString();
        assertEquals(realValue, expectedValue);
    }
}
