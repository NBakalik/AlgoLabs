package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private int size;
    private int startPos;
    private LinkedList<Integer>[] adjList;
    private Queue<Integer> queue;
    private int[] distances;

    public Graph() {
        getSize();
        distances = new int[size];
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
        queue = new LinkedList<>();
    }

    public void add(int value, int neighbor) {
        adjList[value].add(neighbor);
    }

    public int getLargestWay() {
        boolean[] nodes = new boolean[size];
        int neighbor;
        int current = startPos;
        queue.add(current);
        nodes[current] = true;

        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int i = 0; i < adjList[current].size(); i++) {
                neighbor = adjList[current].get(i);
                if (!nodes[neighbor]) {
                    distances[neighbor] = distances[current] + 1;
                    nodes[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return Arrays.stream(distances).max().getAsInt();
    }

    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                int value = Integer.parseInt(line.split(" ")[0]);
                int neighbor = Integer.parseInt(line.split(" ")[1]);
                add(value, neighbor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getSize() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            String line = bufferedReader.readLine();
            startPos = Integer.parseInt(line.split(" ")[1]);
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(Integer.parseInt(line.split(" ")[0]));
            }
            size = Collections.max(arrayList) + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.readFile("input.txt");
        System.out.println(graph.getLargestWay());
    }
}
