package aoj.part14;

import java.util.Scanner;

public class DSL_1_A {
    private static int n;
    private static int q;
    private static int[] id;
    private static int[] sz;

    private static boolean find(int x, int y) {
        return root(x) == root(y);
    }

    private static void union(int x, int y) {
        int i = root(x);
        int j = root(y);

        if (i == j)
            return;
        if (sz[i] > sz[j]){
            id[j] = id[i];
            sz[i] += sz[j];
            sz[j] = 0;
        }
        else {
            id[i] = id[j];
            sz[j] += sz[i];
            sz[i] = 0;
        }
    }

    private static int root(int i) {
        while (i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private static void init() {
        id = new int[n];
        sz = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }


    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();

        init();
        for (int i = 0; i < q; i++) {
            int com = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (com == 0){
                union(x, y);
            }
            if (com == 1){
                if (find(x, y))
                    System.out.println(1);
                else
                    System.out.println(0);
            }

        }

    }
}
