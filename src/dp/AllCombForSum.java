package dp;

import java.util.Arrays;

/**
 * 打印数组中和为 SUM 的所有组合
 */
public class AllCombForSum {

    static int[] f = new int[1000001];
    static int t=0,sum=0;
    public static void main(String[] args) {
        int[] A = {1,1,1,1,2,2,4};
        dfs1(A,0,0,4);

    }


    private static void dfs1(int[] a, int beg, int sum,int target) {
        if (sum == target){
            for (int i1 = 0; i1 < t; i1++) {
                System.out.print(a[f[i1]] + " ");
            }
            System.out.println();
            return ;
        }
        if (sum > target) {
            return;
        }
        int pre = -1;
        for(int i=beg;i<a.length;i++)
        {
            int sum1 = sum;
            if (pre==a[i])
                continue;
            sum1 += a[i];
            f[t++] = i;
            dfs1(a, i+1, sum1, target);
            t--;
            sum1 -= a[i];
            pre = a[i];
        }

    }

    private static void dfs(int[] a, int u, int cur,int target) {
        f[t++]=u;
        sum+=a[u];
        for(int i=u+1;i<a.length;i++)
        {
            sum = cur+a[i];
            if(sum<target)
                dfs(a,i,sum,target);
            else if(sum==target) {
                for (int i1 = 0; i1 < t; i1++) {
                    System.out.print(a[f[i1]] + " ");
                }
                System.out.println(a[i]);
            }
        }
        t--;
        sum-=a[u];
    }

}
