package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * 首先判断有无解，如果最小面额硬币大于1则无解，因为搭配不出1，
     * 	如果有一则有解，因为所有面额都可以由1堆积出来。
     * 	接下来思考一个问题，假设当前硬币可以组合出1到5的任意面额，
     * 	那么添加一枚面额为6的硬币就可以搭配出1到11的任意面额，
     * 	于是我们依照这个思路，假设当前硬币面值的和为sum，每一次添加硬币时，
     * 	从大到小搜索，将搜索到的第一枚面值小于等于sum+1的硬币加入，
     * 	（sum+1是上限），并将计数器+1，更新sum值
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }
        Arrays.sort(coins);

        if (coins[0] != 1) {
            System.out.println("-1");
            return;
        }
        int sum = 0;
        int ret = 0;
        while (true) {
            if (sum >= m) {
                System.out.println(ret);
                return;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (coins[i] <= sum + 1) {
                    sum += coins[i];
                    ret++;
                    break;
                }
            }
        }
    }

}
