package tout;

import java.util.Scanner;


public class Main4 {
    public static void main(String args[]) {
        double MINF = 1e-8;
        Scanner cin = new Scanner(System.in);
        int N, M;
        double[] INPUT = new double[100005];
        double l = MINF, r = 0, mid;
        int i = 0, cur = 0;
        N = cin.nextInt();
        M = cin.nextInt();
        for (i = 0; i < N; i++) {
            INPUT[i] = cin.nextInt();
            if (r < INPUT[i]) {
                r = INPUT[i];
            }
        }
        r += MINF;
        while (l + MINF <= r) {
            mid = (l + r) * 0.5;
            for (i = cur = 0; i < N; i++) {
                cur += (int) (INPUT[i] / mid);
                if (cur > M) {
                    break;
                }

            }
            if (cur >= M) {
                l = mid + MINF;
            } else {
                r = mid - MINF;
            }
        }
        System.out.printf("%.2f", l);
    }
}
