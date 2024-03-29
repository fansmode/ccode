package niuke;

import java.util.ArrayList;

/**
 *二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为
 * 输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPathForSum {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        //找到一条路径
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        //去掉 回溯
        path.remove(path.size() - 1);
    }

}
