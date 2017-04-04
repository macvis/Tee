package week1.homework.linkedList;

import week1.homework.list.List;

/**
 * Created by macvi on 2017/4/3.
 */
public class LinkedList implements List {
    private Node head;

    public LinkedList() {
        this.head = new Node();
    }

    public void add(Object o) {
        if (this.head.data == null) {
            this.head = new Node(o, null);
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(o, null);
        }
    }

    public void add(int index, Object o) {
        if (index > this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            Node newNode = new Node(o, this.head);
            this.head = newNode;
            return;
        }

        if(index == this.size()){
            this.add(o);
            return;
        }

        Node before = getNode(index - 1);
        Node next = getNode(index);
        Node newNode = new Node(o, next);
        before.next = newNode;

    }

    private Node getNode(int index) {
        int i = 0;
        Node temp = this.head;
        while (temp.data != null) {
            if (index == i) {
                return temp;
            }

            if (temp.next != null) {
                temp = temp.next;
            } else break;

            i++;
        }

        return null;
    }

    public Object get(int index) {
        if (index > this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return this.getNode(index).data;
    }

    public Object remove(int index) {
        if(index > this.size() || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Object removed = get(index);

        Node before = getNode(index - 1);
        Node next = getNode(index + 1);
        before.next = next;

        return removed;
    }

    public int size() {
        int size = 0;
        Node temp = this.head;
        while (temp.data != null) {
            size++;
            if (temp.next != null) {
                temp = temp.next;
            } else break;
        }

        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node temp = this.head;
        while (temp.data != null) {
            sb.append(temp.data.toString()).append(",");
            if (temp.next != null) {
                temp = temp.next;
            } else break;
        }

        return sb.toString();
    }

    private static class Node {
        Object data;
        Node next;

        public Node() {}

        public Node(Object obj, Node next) {
            this.data = obj;
            this.next = next;
        }

    }

}
