package a360;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int common = n - m;
        int res = 0;
        for (int i = 0; i < common; i++) {
            if (res < a[i] + a[2 * common - i - 1]) {
                res = a[i] + a[2 * common - i - 1];
            }
        }
        System.out.println(res);


        sc.close();
    }
}
