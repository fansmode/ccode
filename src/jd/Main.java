package jd;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(1);
        map.put(1, root);
        int child, parent;
        TreeNode newNode;
        for (int i = 1; i <= n - 1; i++) {
            child = cin.nextInt();
            parent = cin.nextInt();
            newNode = new TreeNode(child);
            if (map.get(parent).child == null) {
                map.get(parent).child = new ArrayList<>();
            }
            map.get(parent).child.add(newNode);
            map.put(child, newNode);
        }
        int max = 0;
        for (TreeNode node : root.child) {
            max = subNodeNum(node) + 1 > max ? subNodeNum(node) + 1 : max;
        }
        System.out.println(max + 1);
    }

    static int subNodeNum(TreeNode root) {
        if (root.child == null) {
            return 0;
        }
        int subSize = 0;
        for (TreeNode node : root.child) {
            subSize += subNodeNum(node);
        }
        return 1 + subSize;
    }

    static class TreeNode {
        int val;
        ArrayList<TreeNode> child;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
