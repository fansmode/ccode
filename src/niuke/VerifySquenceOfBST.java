package niuke;

/**
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        if(sequence.length==1)
            return true;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int root = sequence[end];
        int cur = start;
        while (cur < end && sequence[cur] <= root) {
            cur++;
        }
        for (int i = cur; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        return verify(sequence,start,cur - 1) && verify(sequence,cur,end - 1);
    }


}
