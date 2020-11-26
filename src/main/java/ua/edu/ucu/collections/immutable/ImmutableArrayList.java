package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private Object[] arrayList;
    private int arraySize = 0;

    public ImmutableArrayList() {
        this.arrayList = new Object[0];
    }

    public ImmutableArrayList(Object[] arr) {
        this.arrayList = arr;
        this.arraySize = arr.length;
    }

    private void checkBounds(int i) {
        if (i < 0 || i >= this.arraySize) {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public ImmutableList add(Object e) {
        return add(-1, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index != -1) {
            checkBounds(index);
        }
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(-1, c);
    }

    // Index -1 reserved for last index placement
    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index == -1) {
            index = arraySize;
        } else {
            checkBounds(index);
        }
        int newLen = arraySize + c.length;
        Object[] newArray = new Object[newLen];
        int j = 0;
        for (int i = 0; i < newLen; ++i) {
            if (i < index) {
                newArray[i] = arrayList[i];
            } else if (i >= index && j < c.length) {
                newArray[i] = c[j];
                ++j;
            } else {
                newArray[i] = arrayList[i - j];
            }
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        checkBounds(index);
        return arrayList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        checkBounds(index);
        Object[] newArray = new Object[--arraySize];
        if (arraySize - 1 >= 0) {
            System.arraycopy(arrayList, 0, newArray, 0, arraySize - 1);
        }
        for (int i = index + 1; i < arraySize; ++i) {
            newArray[i - 1] = arrayList[i];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkBounds(index);
        Object[] newArray = new Object[arraySize];
        if (arraySize >= 0) {
            System.arraycopy(arrayList, 0, newArray, 0, arraySize);
        }
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arraySize; ++i) {
            if (e == arrayList[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList(new Object[0]);
    }

    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] outputArray = new Object[arraySize];
        if (arraySize >= 0) {
            System.arraycopy(arrayList, 0, outputArray, 0, arraySize);
        }
        return outputArray;
    }
}
