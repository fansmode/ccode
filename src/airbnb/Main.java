package airbnb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {


    static String calculate(int m, int k) {
        int[] num = new int[m+1];
        int[] age = new int[m+1];
        num[0] = 2;
        num[1] = 2;
        num[2] = 3;
        age[1] = 1;
        age[2] = 3;
        int currentNum = 2;
        int lengOfNum = 2;
        int year;
        for (year = 2020;; year++) {
            for (int j = 1; j <= lengOfNum; j++) {
                age[j]++;
                if (age[j] >= 3) {
                    currentNum++;
                    num[currentNum] = num[currentNum - 2] + num[currentNum - 3];
                    age[currentNum] = 1;
                    System.out.println(currentNum + ":" + num[currentNum]+ ":" + year);
                    if (currentNum == m) {
                        break;
                    }
                }
            }
            lengOfNum = currentNum;
            if (currentNum == m) {
                break;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] numB = Arrays.copyOf(num, num.length);
        for (int i = 0; i < numB.length; i++) {
            numB[i] = reverInt(numB[i]);
            map.put(numB[i], i);
        }
        Arrays.sort(numB);

        int nnn = map.get(numB[numB.length - k]);


        return num[m] + "," + year + "," + nnn;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(calculate(30,3));

    }

    static int reverInt(int a) {
        int res = 0;
        while (a != 0) {
            res = (a % 10) + res * 10 ;
            a = a / 10;
        }
        return res;
    }

    static long mthNumber(int m) {
        long[] num = new long[m + 1];
        num[1] = 2;
        num[2] = 3;
        num[3] = 4;
        for (int i = 4; i <= m; i++) {
            num[i] = num[i - 2] + num[i - 3];
        }
        return num[m];
    }

}