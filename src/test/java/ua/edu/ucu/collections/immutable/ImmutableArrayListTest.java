package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {

    public void testListValueAdd(ImmutableArrayList arrayList, Object[] array, Object e, int index, Object[] expected) {
        ImmutableArrayList newArrayList;
        if (index == -1) {
            System.out.println("Testing append with one value. Reason: [index = -1]");
        }
        newArrayList = (ImmutableArrayList) arrayList.add(index, e);
        Object[] expectedValue = expected;
        Object[] realValue = newArrayList.toArray();
        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    public void TestArrayListObjListAdd(Object[] outerArray, Object[] innerArray, int index, Object[] expectedValue) {
        ImmutableArrayList arrayList = new ImmutableArrayList(outerArray);
        ImmutableArrayList newArrayList;
        if (index != -1) {
            newArrayList = (ImmutableArrayList) arrayList.addAll(index, innerArray);
        } else {
            System.out.println("Testing append with obj list. Reason: [index = -1]");
            newArrayList = (ImmutableArrayList) arrayList.addAll(innerArray);
        }
        Object[] realValue = newArrayList.toArray();
        assertArrayEquals(realValue, expectedValue);
        assertEquals(realValue, expectedValue);
    }

    public void TestArrayGet(Object[] outerArray, int index, Object expectedValue) {
        ImmutableArrayList arrayList = new ImmutableArrayList(outerArray);
        Object realValue = arrayList.get(index);
        assertEquals(realValue, expectedValue);
    }

    public void TestArraySet(Object[] outerArray, int index, Object value, Object expectedValue) {
        ImmutableArrayList arrayList = new ImmutableArrayList(outerArray);
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.set(index, value);
        Object realValue = newArrayList.get(index);
        assertEquals(realValue, expectedValue);
    }

    public void TestArrayRemove(Object[] outerArray, int index, Object expectedValue) {
        ImmutableArrayList arrayList = new ImmutableArrayList(outerArray);
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.remove(index);
        Object realValue = newArrayList.get(index);
        assertEquals(realValue, expectedValue);
    }

    public void TestArrayIndexOf(Object[] outerArray, Object value, int expectedValue) {
        ImmutableArrayList arrayList = new ImmutableArrayList(outerArray);
        int realValue = arrayList.indexOf(value);
        assertEquals(realValue, expectedValue);
    }


    // add testing
    @Test
    public void testArrayListAddOneElem() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableArrayList list01 = new ImmutableArrayList(arr01);
        int element = 8;
        Object[] expectedValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8};
        testListValueAdd(list01, arr01, element, -1, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem2() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableArrayList list01 = new ImmutableArrayList(arr01);
        Object element = null;
        Object[] expectedValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, null};
        testListValueAdd(list01, arr01, element, -1, expectedValue);
    }

    @Test
    public void testArrayListAddOneElem3() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ImmutableArrayList list01 = new ImmutableArrayList(arr01);
        int element = 7;
        Object[] expectedValue = {7, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        testListValueAdd(list01, arr01, element, 0, expectedValue);
    }

    // addAll testing
    @Test
    public void testArrayListAddObjList() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] arr02 = new Object[]{1, 1, 1, 1};
        Object[] expectedValue = new Object[]{1, 2, 3, 1, 1, 1, 1, 4, 5, 6, 7, 8, 9};
        TestArrayListObjListAdd(arr01, arr02, 3, expectedValue);
    }

    @Test
    public void testArrayListAddObjList2() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] arr02 = new Object[]{};
        Object[] expectedValue = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TestArrayListObjListAdd(arr01, arr02, 3, expectedValue);
    }

    @Test
    public void testArrayListAppendObjList() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] arr02 = new Object[]{1,3,3};
        Object[] expectedValue = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1,3,3};
        TestArrayListObjListAdd(arr01, arr02, -1, expectedValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayListOutOfBounds() {
        Object[] arr01 = new Object[]{};
        Object[] arr02 = new Object[]{};
        Object[] expectedValue = new Object[]{};
        TestArrayListObjListAdd(arr01, arr02, 9, expectedValue);
    }

    @Test
    public void testArrayGetN01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = 2;
        Object expectedValue = 3;
        TestArrayGet(arr01, index, expectedValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayGetN02() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = 200;
        Object expectedValue = null;
        TestArrayGet(arr01, index, expectedValue);
    }

    @Test
    public void testArraySetN01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = 0;
        Object value = 77;
        Object expectedValue = 77;
        TestArraySet(arr01, index, value, expectedValue);
    }

    @Test
    public void testArrayRemoveN01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = 1;
        Object expectedValue = 3;
        TestArrayRemove(arr01, index, expectedValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayRemoveN02() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = 22;
        Object expectedValue = 3;
        TestArrayRemove(arr01, index, expectedValue);
    }

    @Test
    public void testArrayIndexOfN01() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object value = 9;
        int expectedValue = 8;
        TestArrayIndexOf(arr01, value, expectedValue);
    }

    @Test
    public void testArrayIndexOfN02() {
        Object[] arr01 = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object value = 0;
        int expectedValue = -1;
        TestArrayIndexOf(arr01, value, expectedValue);
    }

    public void printArray(Object[] arr) {
        System.out.println("---------");
        for (Object o : arr) {
            System.out.println(o);
        }
        System.out.println("---------");
    }
}
