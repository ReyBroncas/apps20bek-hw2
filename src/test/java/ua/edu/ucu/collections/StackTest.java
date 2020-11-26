package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testAddingElement01() throws IllegalAccessException {
        Stack stack01 = new Stack();
        stack01.push(4);
        stack01.push(5);
        stack01.push(6);
        Object realValue = stack01.pop();
        Object expectedValue = 6;
        assertEquals(realValue, expectedValue);
    }

    @Test
    public void testAddingElement02() throws IllegalAccessException {
        Stack stack01 = new Stack();
        stack01.push(5);
        stack01.push(6);
        Object realValue = stack01.peek();
        Object expectedValue = 6;
        assertEquals(realValue, expectedValue);
    }

    @Test
    public void testAddingElement03() throws IllegalAccessException {
        Stack stack01 = new Stack(new Object[]{4,5,6});
        stack01.push(7);
        Object realValue = stack01.peek();
        Object expectedValue = 7;
        assertEquals(realValue, expectedValue);
    }

    @Test(expected = IllegalAccessException.class)
    public void testAddingElement04() throws IllegalAccessException {
        Stack stack01 = new Stack();
        Object realValue = stack01.peek();
        Object expectedValue = 6;
        assertEquals(realValue, expectedValue);
    }
}
