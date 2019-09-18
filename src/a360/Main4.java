package a360;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] input = new int[n];
        int[] a = init(m + 1);
        int ret = -1;
        for (int i = 0;i<n ;i++){
            input[i] = sc.nextInt();
        }

        int start = 0, end = 0;
        for (int i = 0; i < input.length; i++) {
            start = i;
            for (int j = i; j < input.length; j++){



            }

        }

        System.out.println(ret);
        sc.close();
    }

    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 1;i<a.length;i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static int[] init(int n) {
        int a[] = new int[n];
        for (int i : a) {
            i = 0;
        }
        return a;
    }

}
