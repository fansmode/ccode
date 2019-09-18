package ds;

public class Merge {

    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;//数组a最后元素的索引
        int indexB = lastB - 1;//数组b最后元素的索引
        int indexMerged = lastB + lastA - 1;//合并后数组的最后元素索引
        /*合并a和b,从这两个数组的最后元素开始*/
        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexMerged--;
                indexA--;
            } else {
                a[indexMerged] = b[indexB];//复制元素
                indexMerged--;
                indexB--;
            }
        }
        /*将数组b剩余元素复制到适当的位置*/
        while (indexB >= 0) {
            a[indexMerged] = b[indexB];
            indexMerged--;
            indexB--;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeNoRever(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeHead;
    }

}

class ListNode {
    int val;
    ListNode next;
}