package jd;


import java.util.Scanner;

public class Main3 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        int t = m;
        String[] ss = new String[m + 1];
        while (m >= 1) {
            ss[t - m + 1] = cin.next();
            m--;
        }
        String T = cin.next();



    }

}
