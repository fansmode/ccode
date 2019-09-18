package dp;

/**
 * 排列组合   C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, n) = C(n, 0) = 1, C(0, 0) = 1
 *
 * i \ j	0	1	2	…	k-1	k
 * 0	    1
 * 1	    1	1
 * 2	    1	…	1
 * …	    …			…
 * k - 1	1			…	1
 * k	    1				…	1
 * …	   …					…
 * n - 1	1			…	C(n-1, k-1)	C(n-1, k)
 * n	    1				…	        C(n, k)
 */
public class Comb {

    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i <= 8; i++) {
            System.out.println(binomial(n,i));
        }
    }

    public static long binomial(int n, int k) {
        if (k == 0 || k== n) {
            return 1;
        }
        long[] arr = new long[k + 1];
        arr[0] = 1;
        for(int i = 1;i <= n;i++){
            if (i <= k) {
                arr[i] = 1;
                for (int j = i - 1; j >= 1; j--) {
                    arr[j] = arr[j] + arr[j - 1];
                }
            } else {
                for (int j = k; j>=1;j--){
                    arr[j] = arr[j] + arr[j - 1];
                }
            }
        }
        return arr[k];
    }


}














