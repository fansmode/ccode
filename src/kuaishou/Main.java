package kuaishou;

import java.util.Scanner;

public class Main {

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
        inOrder(nodes,0);
        System.out.println("True");
    }

    public static void inOrder(int[] nodes,int root) {
        if (root < nodes.length) {
            inOrder(nodes,2*root +1);
            System.out.println(root);
            inOrder(nodes,2*root +2);
        }
    }

}
