package ua.edu.ucu.collections.immutable;

public class Node {
    private Object value;
    private Node next;
    private Node prev;

    public Node(Object value) {
        this.value = value;
    }

    public void setNext(Node value) {
        this.next = value;
    }

    public void setPrev(Node value) {
        this.prev = value;
    }

    public Object getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setValue(Object e) {
        this.value = e;
    }
}