package jd;

import java.util.Scanner;

public class Main2 {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] tree = new int[n + 1];
        int child, parent;
        int a = -1;
        int number;
        for (int i = 0; i < n - 1; i++) {
            child = cin.nextInt();
            parent = cin.nextInt();
            tree[child] = parent;
        }
        for (int i = 1; i < n + 1; i++) {
            if (tree[i] == 1) {
                number = nodeCount(tree, i);
                a = number > a ? number : a;
            }
        }
        System.out.println(a);

    }

    static int nodeCount(int[] tree, int root) {
        int num = 1;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] == root) {
                num += nodeCount(tree, i);
            }
        }
        return num;
    }
}