package ds;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;

public class BinTree {

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(3);
        test.left.left = new TreeNode(4);
        test.left.right = new TreeNode(5);
        test.right.left = new TreeNode(6);

        top2BotOrder(test);
        System.out.println();
        mirror(test);
        top2BotOrder(test);
        mirrorUnRe(test);
        top2BotOrder(test);

        System.out.println();
        List<Integer> r = rightSideView(test);
        for (Integer integer : r) {
            System.out.print(integer + " ");
        }

//        top2BotOrder(test);
//        System.out.println("preOrder : ");
//        preOrderRecur(test);
//        System.out.println();
//        preOrder(test);
//        System.out.println();
//        System.out.println("inOrder : ");
//        inOrderRecur(test);
//        inOrder(test);
//        System.out.println();
//        System.out.println("posOrder : ");
//        posOrderRecur(test);
//        posOrder(test);

    }

    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    //右视图
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode lastInLayer;
        while (!queue.isEmpty()) {
            //遍历每层最后一个
            for (int size = queue.size(); size > 0; size--) {
                lastInLayer = queue.poll();
                if (lastInLayer.left != null) {
                    queue.offer(lastInLayer.left);
                }
                if (lastInLayer.right != null) {
                    queue.offer(lastInLayer.right);
                }
                if (size == 1) {
                    res.add(lastInLayer.val);
                }
            }
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 先序遍历
     */
    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    //先序遍历的非递归的写法，反着它的顺序写
    // 1.先放中节点
    // 2.有右节点放右节点
    // 3.有左节点放左节点
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode top;
        while (!stack.isEmpty()) {
            top = stack.pop();
            System.out.print(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        System.out.println();

    }

    /**
     * 中序遍历
     */
    public static void inOrderRecur(TreeNode root) {
        if (root == null) return;
        inOrderRecur(root.left);
        System.out.print(root.val + " ");
        inOrderRecur(root.right);
    }

    //中序遍历的非递归的写法，
    // 1.左节点不为null则压入左节点
    // 2.左节点为null时，pop并打印，左节点
    // 3.在往右，右节点为null时，pop并打印
    // 4.右节点不为null时，压入右节点
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历
     */
    public static void posOrderRecur(TreeNode root) {
        if (root == null) return;
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.val + " ");
    }

    //和前序遍历一样的只不过是使用了两个栈
    //在前序遍历的时候将 中 右 左 节点压栈
    //在原来是打印的地方不打印，将本该打印的节点压到第二个栈中
    //这样第二个栈的出栈顺序就是 右 左 中了
    public static void posOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode top;
        stack.push(root);
        while (!stack.isEmpty()) {
            top = stack.pop();
            stack2.push(top);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
        System.out.println();
    }

    // 后序遍历
    public static void pos1Order(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root; //当前访问节点
        TreeNode pre = null; //上一个访问的节点
        //先把cur移动到左子树最下边
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            //走到这里，cur都是空，并已经遍历到左子树底端
            cur = stack.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (cur.right == null || pre == cur.right) {
                System.out.print(cur.val);
                //修改最近被访问的节点
                pre = cur;
            }
            //若左子树刚被访问过，则需先进入右子树(根节点需再次入栈)
            else {
                //根节点再次入栈
                stack.push(cur);
                //进入右子树，且可肯定右子树一定不为空
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

            }
        }
    }

    //层次遍历
    public static void top2BotOrder(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode head;
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head == null) {
                break;
            }
            System.out.print(head.val + " ");
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    /**
     * 请实现一个函数按照之字形打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推
     */
    public ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null)
            return ret;
        queue.add(pRoot);
        TreeNode head;
        int i = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if ((i & 1) == 0) {
                Collections.reverse(list);
            }
            i++;
            if (list.size() > 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    /**
     * 反转二叉树
     */
    static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.right != null) {
            mirror(root.right);
        }
        if (root.left != null)
            mirror(root.left);
    }

    static void mirrorUnRe(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode head;
        TreeNode temp;
        queue.add(root);
        while (!queue.isEmpty()) {
            head = queue.poll();
            temp = head.left;
            head.left = head.right;
            head.right = temp;
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，
     * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回。
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        /*
         * 输入合法性判断， 不能为空，先序和后序长度要一致
         */
        if (pre == null || in == null || pre.length != in.length)
            return null;

        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * @param pre 前序遍历
     * @param ps  前序遍历的开始位置
     * @param pe  前序遍历的结束位置
     * @param in  中序遍历
     * @param is  中序遍历的开始位置
     * @param ie  中序遍历的结束位置
     * @return 数的根节点
     */
    private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe) return null;

        // 取前序遍历的第一个数字就是根节点
        int value = pre[ps];
        // 在中序遍历中中寻找根节点
        int index = is;
        while (index <= ie && value != in[index]) {
            index++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie)
            throw new RuntimeException("Invalid Iuput!");

        // 创建当前根节点，并为根节点赋值
        TreeNode node = new TreeNode(value);
        // 递归调用构建当前节点的左子树
        node.left = construct(pre, ps + 1, ps + index - is, in, is, index - 1);
        // 递归调用构建当前节点的右子树
        node.right = construct(pre, ps + index - is + 1, pe, in, index + 1, ie);

        return node;
    }


    private void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val + " ");
            printTree(root.right);
        }
    }

    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    /**
     * 首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
     * * 左子树的右子树和右子树的左子树相同即可，采用递归
     * * 非递归也可，采用栈或队列存取各级子树根节点
     */
    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val //为镜像的条件：左右节点值相等
                && isSymmetrical(left.left, right.right) //2.对称的子树也是镜像
                && isSymmetrical(left.right, right.left);
    }

    /**
     * 求二叉树的直径
     * 一个节点的最大直径 = 它左树的高度 +  它右树的高度
     * 然后其实就是遍历每个节点，找出所有节点中的直径的最大值即可。
     */
    int max = 0; //最大直径即是最大高度和

    public int getMaxDis(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDisOfLeft = getMaxDis(root.left);
        int maxDisOfRight = getMaxDis(root.right);
        //max记录当前的最大高度和
        max = Math.max(maxDisOfLeft + maxDisOfRight, max);
        // 计算的直径是左树高度+右树高度，所以这里返回当前树的高度，以供使用
        return Math.max(maxDisOfLeft, maxDisOfLeft) + 1;
    }


    /**
     * 求二叉树的最大深度
     */
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLenOfLeft = getMaxDepth(root.left);
        int maxLenOfRight = getMaxDepth(root.right);
        return Math.max(maxLenOfLeft, maxLenOfRight) + 1;
    }

    /**
     * 求二叉树的最大深度
     * 非递归，层次遍历 统计层数
     */
    public int getMaxDepthUncur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode head;
        int lay = 0;
        int currentNum = 0;
        while (!queue.isEmpty()) {
            // 每一层走完，加一次
            currentNum = queue.size();
            while (currentNum-- > 0) {
                head = queue.poll();
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            lay++;
        }
        return lay;
    }

    /**
     * 二叉树的最大路径和
     */
    public int maxPathSum(TreeNode root) {
        gain(root);
        return maxSum;
    }

    int maxSum = Integer.MIN_VALUE;

    /**
     * 包含当前节点的一条最大路径
     *
     * @param node
     * @return
     */
    public int gain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(gain(node.left), 0);
        int right = Math.max(gain(node.right), 0);

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left, right);
    }

    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    /**
     * 完全二叉树的最后一个节点
     * 二分查找   看深度等于最大深度的点在左边还是右边
     *
     * @param root
     * @return ：类似于二分查找，首先遍历最左分支，求出二叉树的高度；
     * 然后对于每个子树的根节点，先从他的右子树开始，沿着左分支一直走到最后一层，
     * 如果深度等于树的深度且该最后节点右边没有节点，则为所求；否则，右侧有节点，则遍历右子树，深度小于树的深度，则遍历左子树。时间复杂度是O(logn)
     */
    public TreeNode getMaxDepth1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        int depth = 0;
        //计算深度
        TreeNode cur = root;
        while (cur != null) {
            depth++;
            cur = cur.left;
        }

        TreeNode temp = root;
        int curDepth = 0;
        int level = 0;
        while (root != null) {
            //根节点层数  遍历到哪一层
            level++;
            //防止右子树为空
            if (level == depth) {
                break;
            }
            temp = root;
            if (temp.right != null) {
                TreeNode p = temp;
                temp = temp.right;
                curDepth = level + 1;
                while (temp.left != null) {
                    curDepth++;
                    p = temp;
                    temp = temp.left;
                }
                if (curDepth < depth) {
                    root = root.left;
                } else if (p.right == null || p.right == temp) {
                    return temp;
                } else {
                    root = root.right;
                }
            } else {
                root = root.left;
            }
        }
        return root;
    }

    /**
     * 最低公共祖先
     * 1. 二叉搜索数
     **/
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    TreeNode ans;
    public boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}