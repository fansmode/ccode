package dp;

import java.util.Arrays;

/**
 * LCS(x,y) =
 * (1) LCS(x - 1,y - 1) + 1 如果Ax ＝ By
 * (2) max(LCS(x – 1, y) , LCS(x, y – 1)) 如果Ax ≠ By
 * (3) 0 如果x = 0或者y = 0
 */
public class LCS {

    public static void main(String[] args) {
        String a = "abdec";
        String b = "bdeac";
        int[][] pathX = new int[a.length()+1][b.length()+1];
        int[][] pathY = new int[a.length()+1][b.length()+1];
        int len = lcs(a,b,pathX,pathY);
        int j = a.length();
        int k = b.length();
        System.out.println(len);
        while (j >= 1 && k >= 1) {
            System.out.println(a.charAt(j - 1));
            j = pathX[j][k];
            k = pathY[j][k];
        }

    }

    public static int lcs(String str1, String str2, int[][] pathX, int[][] pathY) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                    pathX[i][j] = 0;
                    pathY[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    pathX[i][j] = i - 1;
                    pathY[i][j] = j - 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                    if (c[i - 1][j] > c[i][j - 1]) {
                        pathX[i][j] = i - 1;
                        pathY[i][j] = j;
                    } else {
                        pathX[i][j] = i;
                        pathY[i][j] = j - 1;
                    }
                }
            }
        }
        return c[len1][len2];
    }

}
