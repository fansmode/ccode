package dp;

import java.util.Scanner;

/**
 * 拼凑面额
 * 给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，
 * 编写程序求组成N（N为0-10000的非负整数）的不同组合的个数
 */
public class MoneyComb {

    public static void main(String[] args) {
        int[] value = {1,5,10,20,50,100};
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(numOfCom(value, N));
    }

    public static long numOfCom(int[] value, int N) {
        if (N == 0) {
            return 0;
        }
        long[] res = new long[N + 1];
        int i,j;
        for (i = 0; i <= N; i++) {
            res[i] = 1;
        }

        for (i = 1; i < value.length; i++) {
            for (j = value[i];j <= N; j++){
                res[j] += res[j - value[i]];
            }
        }
        return res[N];
    }

}
