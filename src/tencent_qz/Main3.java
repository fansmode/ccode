package tencent_qz;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] a = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
            max = Math.max(max, a[i]);
        }
        int[] person = new int[n + 1];
        person[0] = m;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if ( a[i] > person[i]) {
                person[i] += person[i - 1];
                res++;
            }else {
                person[i] += person[i - 1];
                if (i < n) {
                    person[i + 1] = person[i];
                }
                res++;
            }
        }
        System.out.println(res+1);

    }

}