package lk;

public class LK160 {

    /**
     * 找到两个单链表相交的起始节点
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0, bLen = 0;
        ListNode cA = headA, cB = headB;
        while (cA != null) {
            aLen++;
            cA = cA.next;
        }
        while (cB != null) {
            bLen++;
            cB = cB.next;
        }
        int dis;
        boolean aIsLonger = false;
        if (aLen > bLen) {
            aIsLonger = true;
            dis = aLen - bLen;
        } else {
            dis = bLen - aLen;
        }


        cA = headA;
        cB = headB;
        if (aIsLonger) {
            for (; dis > 0; dis--) {
                cA = cA.next;
            }
        } else {
            for (; dis > 0; dis--) {
                cB = cB.next;
            }
        }

        while (cA != null && cB != null) {
            if (cA == cB) {
                return cA;
            }
            cA = cA.next;
            cB = cB.next;
        }
        return null;
    }

}
