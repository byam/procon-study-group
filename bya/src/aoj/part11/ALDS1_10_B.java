package aoj.part11;

import java.util.Scanner;

public class ALDS1_10_B {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            String stringA = scanner.next();
            String stringB = scanner.next();

            System.out.println(lcs(stringA, stringB));
        }

    }

    private static int lcs(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        X = " " + X;
        Y = " " + Y;

        int[][] d = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if(X.charAt(i) == Y.charAt(j)){
                    d[i][j] = d[i-1][j-1] + 1;
                }
                else {
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }

        return d[m][n];
    }


}
