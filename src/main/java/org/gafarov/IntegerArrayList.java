package org.gafarov;

public class IntegerArrayList implements IntegerList {
    private static final Integer[] EMPTY_ARRAY = {};
    private Integer[] array;
    private int size;

    public IntegerArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public IntegerArrayList(int[] arr) {
        Integer[] newArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        this.array = newArray;
        this.size = arr.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        try {
            int object = (Integer) o;
            for (int i = 0; i < size; i++) {
                if (array[i].equals(object)) {
                    contains = true;
                    break;
                }
            }
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
        return contains;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Integer[] newArray = new Integer[this.size + 1];
            System.arraycopy(this.array, 0, newArray, 0, index + 1);
            newArray[index] = element;
            System.arraycopy(this.array, index, newArray, index + 1, size - index);
            this.array = newArray;
            this.size = size + 1;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Integer[] newArray = new Integer[this.size - 1];
            Integer removedElem = this.array[index];
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array, index + 1, newArray, index, size - index - 1);
            this.array = newArray;
            this.size = size - 1;
            return removedElem;
        }
    }

    @Override
    public int indexOf(Integer o) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (o.equals(array[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean add(Integer e) {
        Integer[] newArray = new Integer[size + 1];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        newArray[this.size] = e;
        this.size = size + 1;
        this.array = newArray;
        return true;
    }

    @Override
    public boolean remove(Integer o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(this.array[i])) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

}

