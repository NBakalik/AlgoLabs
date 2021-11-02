package com.company;

import java.util.*;

public class Tarjan {
    private int vertexCount;
    private int id = 0;
    private int[] lowLink;
    private int[] ids;
    private List<Integer>[] graph;
    private List<List<Integer>> sccComp;
    private Stack<Integer> stack;
    private int sccCount = 0;


    public Tarjan(List<Integer>[] graph) {
        this.graph = graph;
        vertexCount = graph.length;
        lowLink = new int[vertexCount];
        ids = new int[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            ids[i] = -1;
        }

        stack = new Stack<>();
        sccComp = new ArrayList<>();
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Vertices");
        int vertexCount = scanner.nextInt();
        List<Integer>[] g = new ArrayList[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            g[i] = new ArrayList<>();
        System.out.println("Enter number of edges");
        int edgeCount = scanner.nextInt();
        System.out.println("Enter " + edgeCount + " x, y coordinates");
        for (int i = 0; i < edgeCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g[x].add(y);
        }

        Tarjan t = new Tarjan(g);
        List<List<Integer>> scComponents = t.getSCComponents();
        System.out.println(t.sccCount);
        System.out.println(scComponents);
    }
}
