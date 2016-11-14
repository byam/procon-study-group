package aoj.part13.ALDS1_12_B;

import java.util.Scanner;

public class Main {

    private static final int MAX_N = 100;
    private static final int INF = 1 << 21;
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private static int n;
    private static int[][] M = new int[MAX_N][MAX_N];


    private static void dijkstra() {
        // initialize
        int[] color = new int[MAX_N]; // visited or not
        int[] d = new int[MAX_N]; // min edge

        for (int i = 0; i < n; i++) {
            color[i] = WHITE;
            d[i] = INF;
        }

        // start node
        d[0] = 0;
        color[0] = GRAY;

        while (true){
            int u = -1;
            int minv = INF;

            // find minimum value vertex
            for (int i = 0; i < n; i++) {
                if (color[i] != BLACK && d[i] < minv){
                    minv = d[i];
                    u = i;
                }
            }

            // didn't find any vertex
            if (u == -1)
                break;
            color[u] = BLACK;

            // add new edges
            for (int v = 0; v < n; v++) {
                if (color[v] != BLACK && M[u][v] != INF){
                    if (d[v] > M[u][v] + d[u]) {
                        d[v] = M[u][v] + d[u];
                        color[v] = GRAY;
                    }
                }

            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println(
                    i + " " + (d[i] == INF ? -1 : d[i])
            );
        }

    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                M[u][scanner.nextInt()] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args){
        input();
        dijkstra();
    }
}
