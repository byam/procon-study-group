package aoj.part11;

import java.util.Scanner;

public class ALDS1_10_C {

    private static final int INF = 1 << 24;
    private static int n;
    private static int[][] d;
    private static int[] p;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        p = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            p[i-1] = r;
            p[i] = c;
        }

        matrix_chain_multiplication();

    }

    private static void matrix_chain_multiplication() {
        d = new int[n+1][n+1];

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                d[i][j] = INF;

                for (int k = i; k <= j-1; k++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k+1][j] + p[i-1] * p[k] * p[j]);
                }
            }
        }

        System.out.println(d[1][n]);
    }
}
