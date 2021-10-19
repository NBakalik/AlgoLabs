package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int size;
    private LinkedList<Integer>[] adjList;
    private Queue<Integer> queue;

    public Graph(int size) {
        this.size = size;
        queue = new LinkedList<>();
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void add(int value, int neighbor) {
        adjList[value].add(neighbor);
    }

    public void printBFS(int n) {
        boolean[] nodes = new boolean[size];
        int value;

        queue.add(n);
        nodes[n] = true;

        while (!queue.isEmpty()) {
            n = queue.poll();
            System.out.print(n + " ");

            for (int i = 0; i < adjList[n].size(); i++) {
                value = adjList[n].get(i);
                if (!nodes[value]) {
                    nodes[value] = true;
                    queue.add(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.add(0, 1);
        graph.add(0, 4);
        graph.add(0, 3);
        graph.add(1, 2);
        graph.add(1, 0);
        graph.add(2, 1);
        graph.add(3, 0);
        graph.add(4, 0);

        graph.printBFS(0);
    }
}
