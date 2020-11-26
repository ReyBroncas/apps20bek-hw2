package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList;

    public Stack() {
        linkedList = new ImmutableLinkedList();
    }

    public Stack(Object[] values) {
        linkedList = new ImmutableLinkedList(values);
    }


    public Object peek() throws IllegalAccessException {
        return linkedList.getLast();
    }

    public Object pop() throws IllegalAccessException {
        Object e = linkedList.getLast();
        this.linkedList = (ImmutableLinkedList) linkedList.removeLast();
        return e;
    }

    public void push(Object elem) {
        this.linkedList = (ImmutableLinkedList) linkedList.add(elem);
    }


}
