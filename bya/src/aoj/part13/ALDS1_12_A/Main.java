package aoj.part13.ALDS1_12_A;

import java.util.Scanner;

public class Main {

    private static final int MAX_N = 100;
    private static final int INF = 1 << 21;
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    static int n;
    static int[][] M = new int[MAX_N][MAX_N];


    private static int prim() {
        // initialize
        int[] color = new int[MAX_N]; // visited or not
        int[] d = new int[MAX_N]; // min edge
        int[] p = new int[MAX_N]; // MST parent node

        for (int i = 0; i < n; i++) {
            color[i] = WHITE;
            d[i] = INF;
            p[i] = -1;
        }

        // start node
        d[0] = 0;

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
                if (color[v] != BLACK && M[v][u] != INF){
                    if (d[v] > M[v][u]) {
                        d[v] = M[v][u];
                        color[v] = GRAY;
                        p[v] = u;
                    }
                }

            }

        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != -1)
                sum += M[p[i]][i];
        }

        return sum;
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int e = scanner.nextInt();
                if (e == -1)
                    M[i][j] = INF;
                else
                    M[i][j] = e;
            }
        }
    }

    public static void main(String[] args){
        input();
        System.out.println(prim());
    }
}
