package org.gafarov;

public class IntegerLinkedList implements IntegerList {
    Node head;
    int size;

    public IntegerLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public IntegerLinkedList(int[] arr) {
        if (arr.length > 0) {
            this.size = arr.length;
            this.head = new Node(null, arr[0]);
            Node currNode = this.head;
            for (int i = 1; i < this.size; i++) {
                currNode.next = new Node(null, arr[i]);
                currNode = currNode.next;
            }
        } else {
            this.head = null;
            this.size = 0;
        }
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
            Node curNode = this.head;
            for (int i = 0; i < size; i++) {
                if (curNode.data.equals(object)) {
                    contains = true;
                    break;
                }
                curNode = curNode.next;
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
            Node curNode = this.head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
            return curNode.data;
        }
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node curNode = this.head;
            for (int i = 0; i < index-1; i++) {
                curNode = curNode.next;
            }
            Node newNode = new Node(curNode.next, element);
            curNode.next = newNode;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node curNode = this.head;
            for (int i = 0; i < index-1; i++) {
                curNode = curNode.next;
            }
            Integer removedElem = curNode.next.data;
            if(curNode.next.next==null){
                curNode.next=null;
            }else {
                curNode.next = curNode.next.next;
            }
            return removedElem;
        }
    }

    @Override
    public int indexOf(Integer o) {
        int index = -1;
        Node curNode = this.head;
        for (int i = 0; i < size; i++) {
            if (o.equals(curNode.data)) {
                index = i;
                break;
            }
            curNode=curNode.next;
        }
        return index;
    }

    @Override
    public boolean add(Integer e) {
        if (size == 0) {
            this.head = new Node(null, e);
            this.size = size + 1;
        } else {
            Node curNode = this.head;
            for (int i = 0; i < size - 1; i++) {
                curNode = curNode.next;
            }
            curNode.next = new Node(null, e);

            this.size = size + 1;
        }
        return true;
    }

    @Override
    public boolean remove(Integer o) {
        Node curNode = this.head;
        for (int i = 0; i < size; i++) {
            if (curNode.data.equals(o)) {
                curNode.next = curNode.next.next;
                return true;
            }
        }
        return false;
    }


    private class Node {
        Integer data;
        Node next;

        public Node(Node next, Integer data) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return this.data;
        }
    }

}
