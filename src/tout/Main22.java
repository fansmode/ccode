package tout;

import java.util.Scanner;

public class Main22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] H = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            H[i] = sc.nextInt();
        }
        H[0] = 0;

        int res = 0;

        int l = 1,r = 100000;
        int mid = -1;
        int temp;
        while (l <= r) {
            mid = (l + r) / 2;
            temp = find(H, mid);
            if (temp == 1) {
                res = mid;
                r = mid - 1;
            } else if (temp == -1){
                l = mid + 1;
            } else {
                res = mid;
                break;
            }
        }

        System.out.println(res);

    }

    static int find(int[] H,int e) {
        int es = e;
        for (int i = 1;i< H.length;i++){
            es = 2 * es - H[i];
            if (es < 0) {
                return -1;
            }
        }
        if (es > 0) {
            return 1;
        }
        else
            return 0;
    }

}
