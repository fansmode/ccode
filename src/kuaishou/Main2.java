package kuaishou;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] mark = new int[m][n];
        System.out.println(mark(0, 0, m, n, mark, k));

        sc.close();
    }

    static int mark(int x, int y, int rows, int cols, int[][] mark, int threshold) {
        if (x < 0 || y < 0
                || x >= rows
                || y >= cols
                || mark[x][y] == 1
                || sum(x) + sum(y) > threshold) {
            return 0;
        }
        mark[x][y] = 1;
        return mark(x + 1, y, rows, cols, mark, threshold)
                + mark(x - 1, y, rows, cols, mark, threshold)
                + mark(x, y + 1, rows, cols, mark, threshold)
                + mark(x, y - 1, rows, cols, mark, threshold) + 1;
    }

    static int sum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}