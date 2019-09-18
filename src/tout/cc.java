package tout;

import java.util.Scanner;

public class cc {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N > 0) {
            String str = sc.next();

            char[] strArr = str.toCharArray();
            char[] cachArr = new char[strArr.length];
            char[] f = new char[6];
            int i = 0, j = 1, k = 0,cur = 1;
            int n = strArr.length;
            cachArr[0] = strArr[0];
            for (i = 1;i<n;i++) {
                if (strArr[i] == strArr[i - 1]) {
                    if (cur == 2) {
                        continue;
                    }
                    cur++;
                    cachArr[j++] = strArr[i];
                } else {
                    cur = 1;
                    cachArr[j++] = strArr[i];
                }
            }

            n=j;j=0;
            cur=1;f[0]=cachArr[0];
            for (i = 1; i < n; i++) {
                if (cachArr[i] == cachArr[i - 1]) {
                    if (cur == 3) {
                        for (k = 0; k < 3; k++) {
                            strArr[j++] = f[k];
                        }
                        cur = 0;
                    } else {
                        f[cur++] = cachArr[i];
                    }
                } else {
                    if (cur == 2) {
                        f[cur++] = cachArr[i];
                    } else {
                        for(k=0;k<cur;k++) {
                            strArr[j++]=f[k];
                        }
                        cur = 1;
                        f[0] = cachArr[i];
                    }
                }
            }
            for(k=0;k<cur;k++) {
                strArr[j++]=f[k];
            }
            System.out.println(new String(strArr));

            N--;
        }

    }
}