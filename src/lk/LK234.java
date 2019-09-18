package lk;

public class LK234 {

    /**
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * <p>
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        ListNode mid, cur, fast, slow, right, pre;
        fast = slow = head;
        boolean oneMid = false;
        if (head == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast != null && fast.next == null) {
                oneMid = true;
            }
        }
        mid = slow;
        if (oneMid) {
            right = mid.next;
        } else {
            right = mid;
        }
        pre = right;
        cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = right;
            right = cur;
            cur = pre.next;
        }

        while (right != null) {
            if (head.val != right.val) {
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;
    }

}
