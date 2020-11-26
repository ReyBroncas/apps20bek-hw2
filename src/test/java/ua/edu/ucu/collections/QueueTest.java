package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void testAddingElement01() throws IllegalAccessException {
        Queue queue01 = new Queue();
        queue01.enqueue(4);
        queue01.enqueue(5);
        queue01.enqueue(6);
        Object realValue = queue01.dequeue();
        Object expectedValue = 4;
        assertEquals(realValue, expectedValue);
    }

    @Test
    public void testAddingElement02() throws IllegalAccessException {
        Queue queue01 = new Queue();
        queue01.enqueue(5);
        queue01.enqueue(6);
        Object realValue = queue01.peek();
        Object expectedValue = 5;
        assertEquals(realValue, expectedValue);
    }

    @Test
    public void testAddingElement03() throws IllegalAccessException {
        Queue queue01 = new Queue(new Object[]{4, 5, 6});
        Object realValue = queue01.peek();
        Object expectedValue = 4;
        assertEquals(realValue, expectedValue);
    }

    @Test(expected = IllegalAccessException.class)
    public void testAddingElement04() throws IllegalAccessException {
        Queue queue01 = new Queue();
        Object realValue = queue01.peek();
        Object expectedValue = null;
        assertEquals(realValue, expectedValue);
    }
}
