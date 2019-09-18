package jd.qz;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[] input = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = cin.nextInt();
        }
        int res = 0;
        int end = 0;
        for (int i = 1; i <= N; ) {
            end = getIdxOfMinValue(input, i, N);
            res++;
            if (i == N) {
                break;
            } else {
                i = end + 1;
            }
        }
        System.out.println(res);
    }

    static int seIdx = 1;

    public static int getIdxOfMinValue(int[] arr, int start, int end) {
        if (seIdx > start) {
            return seIdx;
        }
        int minV = arr[start];
        int minIdx = start;
        seIdx = start;
        boolean con = false;
        for (int i = start; i <= end; i++) {
            if (minV > arr[i] && !con) {
                con = true;
                seIdx = minIdx;
                minIdx = i;
                minV = arr[i];
            }
            if (con && minV >= arr[i]) {
                seIdx = minIdx;
                minIdx = i;
                minV = arr[i];
            }
        }
        return minIdx;
    }

}
