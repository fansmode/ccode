package tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String input = scanner.next();
        char[] array = input.toCharArray();
        int numOfOne = 0;
        for (char c : array) {
            if (c == '1'){
                numOfOne++;
            }
        }
        int ret = Math.abs(n - numOfOne * 2);
        System.out.println(ret);
    }
}
