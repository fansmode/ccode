package tout;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N > 0) {
            String str = sc.next();

            char[] strArr = str.toCharArray();
            int i = 0, j = 1, k = 2;
            String stage1 = "";
            if (strArr.length >= 3) {
                while (k <= str.length() - 1) {
                    if (strArr[i] == strArr[j] && strArr[j] == strArr[k]) {
                        strArr[i] = '*';
                    }
                    i++;
                    j++;
                    k++;
                }
                stage1 = new String(strArr).replace("*", "");
            }
            i = 0;
            j = 1;
            k = 2;
            int l = 3;
            strArr = stage1.toCharArray();
            if (stage1.length() >= 4) {
                while (l <= stage1.length() - 1) {
                    if (strArr[i] == strArr[j] && strArr[k] == strArr[l]) {
                        strArr[k] = '*';
//                        break;
                    }
                    i++;
                    j++;
                    k++;
                    l++;
                }
            }
            System.out.println(new String(strArr).replace("*", ""));
            N--;
        }

    }

}
