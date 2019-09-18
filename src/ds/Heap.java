package ds;

import java.util.PriorityQueue;

public class Heap {

    final static int[] test = new int[]{1, 5, 3, 8, 4, 6};

    public static void main(String[] args) {
        creat_heap2(test, test.length);
        heap_sort(test);
        outputArr(test);
        System.out.println(findKthLargest(test, 4));
    }

    //寻找第k大的数 前k个大的数
    //小顶堆 堆顶是第k大 来一个数比k大 删除堆顶 入堆 adjust_down
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.offer(num);
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    static void heap_sort(int[] arr) {
        creat_heap2(arr,arr.length);
        for (int i = arr.length - 1; i > 0 ; i--) {
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //adjust
            adjust_down(arr,0, i);
        }
    }

    /**
     * 自上向下建堆
     */
    static void creat_heap(int arr[], int n) {
        int i;
        for (i = 1; i < n; i++) {
            adjust_up(arr, i);
        }
    }

    /**
     * 自下向上建堆
     */
    static void creat_heap2(int arr[], int len) {
        int i = (len >> 1) - 1;
        for (; i >= 0; i--) {
            adjust_down(arr, i, len);
        }
    }

    /**
     * 自上向下调整堆
     * 从父节点调整开始
     */
    private static void adjust_down(int[] arr, int p, int n) {
        int max = p,temp;
        while (p < n >> 1) {
            //找出左右子中最大的
            if ((p << 1) + 1 < n && arr[(p << 1) + 1] > arr[max]) {
                max = (p << 1) + 1;
            }
            if ((p << 1) + 2 < n && arr[(p << 1) + 2] > arr[max]) {
                max = (p << 1) + 2;
            }
            if (max == p) {
                break;
            }
            //交换
            temp = arr[p];
            arr[p] = arr[max];
            arr[max] = temp;

            p = max;
        }
    }

    /**
     * 自底向上调整堆
     */
    static void adjust_up(int arr[], int i) {
        //父节点
        int parent = (i - 1) >> 1;
        int temp;
        while (arr[parent] < arr[i]) {
            //交换i parent
            temp = arr[parent];
            arr[parent] = arr[i];
            arr[i] = temp;
            //赋值
            i = parent;
            parent = (i - 1) >> 1;
            if (parent < 0) {
                break;
            }
        }
    }

    static void outputArr(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }


}
