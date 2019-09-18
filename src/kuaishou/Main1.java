package kuaishou;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if ("None".equals(input)) {
            System.out.println("True");
            return;
        }
        String[] ia = input.split(",");
        int[] nodes = new int[ia.length];
        for (int i = 0; i < ia.length; i++) {
            nodes[i] = Integer.parseInt(ia[i]);
        }
        int pre = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack();
        int s = 1;
        while (s < nodes.length || !stack.isEmpty()) {
            while (s < nodes.length) {
                stack.push(s);
                s = s * 2;
            }
            if (!stack.isEmpty()) {
                s = stack.pop();
                if (pre >= nodes[s - 1]) {
                    System.out.println("False");
                    return;
                } else {
                    pre = nodes[s - 1];
                    s = s * 2 + 1;
                }
            }
        }
        System.out.println("True");
    }

}
