package kuaishou;

import java.util.Scanner;

public class Main99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0x1;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if (0 != (n & flag)) {
                ++res;
            }

            flag = flag << 1;
        }
        System.out.println(res);
        sc.close();
    }
}
