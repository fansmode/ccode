package tencent_qz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] bx = new int[n];
        for (int i = 0; i < n; i++) {
            bx[i] = input.nextInt();
        }
        int[] key = new int[m];
        for (int i = 0; i < m; i++) {
            key[i] = input.nextInt();
        }

        int oddBx = 0;
        for (int b : bx) {
            if (b % 2 == 1) {
                oddBx++;
            }
        }
        int oddKey = 0;
        for (int b : key) {
            if (b % 2 == 1) {
                oddKey++;
            }
        }

        System.out.println(Math.min(oddBx, m - oddKey) + Math.min(n - oddBx, oddKey));

    }

}