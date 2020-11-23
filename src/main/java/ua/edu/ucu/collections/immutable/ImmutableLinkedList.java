package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node tail;
    private Node head;
    private int listSize = 0;

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public ImmutableLinkedList(Object[] values, int size) {
        this();
        Node currNode = new Node(values[0]);
        Node newHead = currNode;

        for (int i = 1; i < size; ++i) {
            Node newNode = new Node(values[i]);
            currNode.setNext(newNode);
            newNode.setPrev(currNode);
            currNode = currNode.getNext();
        }

        this.head = newHead;
        this.tail = currNode;
        this.listSize = size;
    }

    @Override
    public ImmutableList add(Object e) {
//        if (this.listSize == 0 || this.head == null) {
//            return new ImmutableLinkedList(new Object[]{e}, 1);
//        }
//        Object[] values = this.toArray();
//        ImmutableLinkedList newList = new ImmutableLinkedList(values, listSize);
//
//        Node newNode = new Node(e);
//        newNode.setPrev(newList.tail);
//        newList.tail.setNext(newNode);
//        newList.tail = newNode;
//        ++newList.listSize;
//
//        return newList;
        return add(listSize, e);
    }

    private void checkBounds(int i) {
        if (i < 0 || i >= this.listSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkBoundsNotIncluding(int i) {
        if (i < 0 || i > this.listSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Node getNode(Node headNode, int index) {
        checkBoundsNotIncluding(index);
        for (int i = 0; i < index; ++i) {
            System.out.println("[" + i + "] " + headNode.getValue());
            headNode = headNode.getNext();
        }
        if (headNode != null) {
            return headNode.getPrev();
        }
        return null;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        checkBoundsNotIncluding(index);
        if (this.listSize == 0 || this.head == null) {
            return new ImmutableLinkedList(new Object[]{e}, 1);
        }
        Object[] values = this.toArray();
        ImmutableLinkedList newList = new ImmutableLinkedList(values, listSize);

        Node newNode = new Node(e);
        if (index == 0) {
            newList.head.setPrev(newNode);
            newNode.setNext(newList.head);
        } else {
            Node currNode = getNode(newList.head, index);
            System.out.println(currNode);
            System.out.println("im hereidfkljskldfsdfkljskljdfs" + index);
            System.out.println("im herefdkljsdfklsdfkljs");
            System.out.println(currNode.getValue() + "current value ");
            Node tmpNode;
            if (currNode.getNext() != null) {
                tmpNode = currNode.getNext();
                currNode.setNext(newNode);

                tmpNode.setPrev(newNode);

                newNode.setPrev(currNode);
                newNode.setNext(tmpNode);
            } else {
                currNode.setNext(newNode);
                newNode.setPrev(currNode);
                newList.tail = newNode;
            }
        }

        System.out.println("im here");
        System.out.println(newList.toString());
        ++newList.listSize;
        return newList;
    }


    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(listSize, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        checkBounds(index);
        Node newHead = this.head;
        for (int i = 0; i != listSize; ++i) {
            if (i == index) {
                newHead = newHead.getNext();
                break;
            }
            newHead = newHead.getNext();
        }
        return newHead.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkBounds(index);
        Object[] outputArray = this.toArray();
        outputArray[index] = e;
        return new ImmutableLinkedList(outputArray, listSize);
    }

    @Override
    public int indexOf(Object e) {
        Node currNode = this.head;
        for (int i = 0; i != listSize; ++i) {
            if (currNode.getValue().equals(e)) {
                return i;
            }
            currNode = currNode.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] outputArr = new Object[listSize];
        Node currNode = head;
        for (int i = 0; i < listSize; ++i) {
            outputArr[i] = currNode.getValue();
            currNode = currNode.getNext();
        }
        return outputArr;
    }

}
