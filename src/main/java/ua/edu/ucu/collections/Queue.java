package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList;

    public Queue() {
        linkedList = new ImmutableLinkedList();
    }

    public Queue(Object[] values) {
        linkedList = new ImmutableLinkedList(values);
    }

    public Object peek() throws IllegalAccessException {
        return linkedList.getFirst();
    }

    public Object dequeue() throws IllegalAccessException {
        Object e = linkedList.getFirst();
        this.linkedList = (ImmutableLinkedList) linkedList.removeFirst();
        return e;
    }

    public void enqueue(Object e) {
        this.linkedList = (ImmutableLinkedList) linkedList.add(e);
    }
}
