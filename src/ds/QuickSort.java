package ds;

import java.util.ArrayList;

public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {

        /*递归终止条件*/
        if (start >= end)
            return;

        int i = start;
        int j = end;
        int temp = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= temp)
                j--;
            arr[i] = arr[j];

            while (i < j && arr[i] <= temp)
                i++;
            arr[j] = arr[i];
        }

        arr[i] = temp;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 10, 3, 4, 7, 2, 8, 9};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> findKthLargest(int[] input, int k) {
        if (k > input.length || input.length == 0) return new ArrayList();
        helper(input, k, 0, input.length - 1);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(input[i]);
        return res;
    }

    private void helper(int[] input, int k, int s, int e) {
        // 返回的是枢纽元素左边的元素的个数
        int pivot = partion(input, s, e);
        if (pivot == k || pivot + 1 == k) return;
        if (pivot > k) helper(input, k, s, pivot - 1);
        else helper(input, k - pivot - 1, pivot + 1, e);
    }

    private int partion(int[] input, int s, int e) {
        int key = input[s];
        int ss = s;
        while (s < e) {
            while (s < e && input[e] >= key) e--;
            input[s] = input[e];
            while (s < e && input[s] <= key) s++;
            input[e] = input[s];
        }
        input[s] = key;
        return s - ss;
    }

}
