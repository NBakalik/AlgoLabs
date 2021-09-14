package com.company;

public class Main {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(10, 4);
        priorityQueue.add(20, 1);
        priorityQueue.add(40, 3);
        priorityQueue.add(80, 2);
        priorityQueue.add(90, 7);
        priorityQueue.add(50, 5);
        System.out.println(priorityQueue.getSize());
        priorityQueue.printQueue();
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.indexOf(90));
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.peek());
    }
}
