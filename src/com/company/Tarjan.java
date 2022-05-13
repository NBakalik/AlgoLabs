package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Tarjan {
    private int vertexCount;
    private int edgeCount;
    private int id = 0;
    private int[] lowLink;
    private int[] ids;
    private List<Integer>[] graph;
    private List<List<Integer>> sccComp;
    private Stack<Integer> stack;
    private int sccCount = 0;

    public int getSccCount() {
        return sccCount;
    }

    public Tarjan(String filename) {
        getSize(filename);
        lowLink = new int[vertexCount];
        ids = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            ids[i] = -1;
        }
        graph = new ArrayList[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            graph[i] = new ArrayList<>();
        stack = new Stack<>();
        sccComp = new ArrayList<>();
        readFile(filename);
    }

    public void add(int value, int neighbor) {
        graph[value].add(neighbor);
    }

    public List<List<Integer>> getSCComponents() {
        for (int v = 0; v < vertexCount; v++) {
            if (ids[v] == -1) {
                dfs(v);
            }
        }
        return sccComp;
    }

    public void dfs(int at) {
        lowLink[at] = id;
        ids[at] = id++;
        stack.push(at);

        for (int to : graph[at]) {
            if (ids[to] == -1) {
                dfs(to);
            }
            if (stack.contains(to)) {
                lowLink[at] = Integer.min(lowLink[to], lowLink[at]);
            }
        }
        List<Integer> component = new ArrayList<>();

        if (ids[at] == lowLink[at]) {
            for (int i = stack.pop(); ; i = stack.pop()) {
                component.add(i);
                lowLink[i] = ids[at];
                if (i == at) {
                    break;
                }
            }
            sccComp.add(component);
            sccCount++;
        }
    }

    public void getSize(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            vertexCount = Integer.parseInt(line.split(" ")[0]);
            edgeCount = Integer.parseInt(line.split(" ")[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        Tarjan t = new Tarjan("input.txt");
        List<List<Integer>> scComponents = t.getSCComponents();
        System.out.println(t.sccCount);
        System.out.println(scComponents);
    }
}
