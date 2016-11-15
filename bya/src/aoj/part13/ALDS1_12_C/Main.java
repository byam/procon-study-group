package aoj.part13.ALDS1_12_C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static int n;
    private static boolean[] color;
    private static List<List<Edge>> adj = new ArrayList<List<Edge>>();
    private static final int INF = 1 << 24;

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                int f = scanner.nextInt();
                int s = scanner.nextInt();
                adj.get(v).add(new Edge(f, s));
            }
        }
    }

    private static void efficient_dijkstra() {
        color = new boolean[n];
        int[] d = new int[n];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(0, 0));
        Arrays.fill(d, INF);
        d[0] = 0;
        while (!pq.isEmpty()) {
            Edge f = pq.poll();
            int u = f.second;
            color[u] = true;
            if (d[u] < f.first)
                continue;
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).first;
                if (color[v])
                    continue;
                int a = adj.get(u).get(i).second;
                if (d[v] > d[u] + a) {
                    d[v] = d[u] + a;
                    pq.add(new Edge(d[v], v));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d\n", i, d[i]);
        }

    }

    static class Edge implements Comparable<Edge> {
        int first;
        int second;

        public Edge(int first, int second) {
            super();
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Edge o) {
            return this.first - o.first;
        }

    }

    public static void main(String[] args) {
        input();
        efficient_dijkstra();
    }
}