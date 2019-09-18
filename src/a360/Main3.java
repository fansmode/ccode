package a360;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sc.nextInt();
        }

            long cmn = combinationSec(s, n);
            System.out.println((long) (Math.pow(2, (n - s)) * cmn) % 1000000007);

        sc.close();
    }

    public static int c(int a, int b) {
        if (b > a / 2) {
            return c(a, a - b);
        }
        return up(a, b) / up(b, b);
    }

    private static long factorialSec(int m, int n) {
        long sum = 1;

        while(m > 0 && n > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }

    public static long combinationSec(int m, int n) {
        if( m > n )
            return 0;
        if( m > n/2 )
        {
            m = n - m;
        }
        return factorialSec(m, n)/factorialSec(m, m);
    }

    public static int up(int a, int b) {
        int c = 1;
        for (int i = 0; i < b; i++) {
            c = c * a;
            a--;
        }
        return c;
    }

}
