package com.company;

public class PriorityQueue {
    private Node head;
    private int size = 0;

    class Node {
        Object data;
        int priority;
        Node next;


        public Node(Object data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", priority=" + priority +
                    ", next=" + next +
                    '}';
        }

    }

    public void add(Object data, int priority) {
        Node start = head;
        Node temp = new Node(data, priority);
        if (size < 1) {
            head = temp;
        } else if (priority < head.priority) {
            temp.next = head;
            head = temp;
        } else {
            while (start.next != null && start.next.priority < priority) {
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public Node peek() {
        return head;
    }

    public Node pop() {
        Node temp = head;
        head = head.next;
        size--;
        return temp;
    }

    public int indexOf(Object t) {
        Node start = head;
        int index = 0;
        while (start.next != null) {
            index++;
            if (start.data == t) {
                return index;
            }
            start = start.next;
        }
        if (start.data == t)
            return ++index;
        return -1;
    }

    public void printQueue() {
        Node start = head;
        do {
            System.out.println(start.data + " " + start.priority);
            start = start.next;
        } while (start.next != null);
        System.out.println(start.data + " " + start.priority);
    }
}
