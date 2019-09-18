package tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] d = new long[N];
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            p[i] = scanner.nextInt();
        }

        int sum = minSumOfP(d, p, 0, N, 0);
        System.out.println(sum);
    }

    static int minSumOfP(long d[], int p[], int pos, int N, long currentD) {
        int minSum = 100;
        if (pos == N) {
            return 0;
        }
        if (currentD >= d[pos]) {
            minSum = minSumOfP(d, p, pos + 1, N, currentD);
        }
        return Math.min(minSum, minSumOfP(d, p, pos + 1, N, currentD + d[pos]) + p[pos]);
    }

}
