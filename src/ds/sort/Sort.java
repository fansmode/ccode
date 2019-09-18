package ds.sort;

public class Sort {

    public static void main(String[] args) {
        int[] ex = {1, 4, 2, 8, 6, 5, 7};
//        BubleSort(ex);
        SelectSort(ex);
        printArray(ex);
    }

    //冒泡
    public static void BubleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    //选择
    public static void  SelectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int i1 = i + 1; i1 < arr.length; i1++) {
                if (arr[i1] < arr[minIdx]) {
                    minIdx = i1;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    //插入
    public static void InsertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据
        }
    }

    public static void printArray(int arr[]) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public void mergeSort(int A[], int from, int to) {
        if (from < to) {
            int mid = ((to - from) >> 1) + from;
            mergeSort(A, from, mid);
            mergeSort(A, mid + 1, to);
            merge(A, from, mid, to);
        }
    }

    private void merge(int A[], int from, int mid, int to) {
        int[] t = new int[to - from + 1];
        int indexA = from, indexB = mid + 1, indext = 0;
        while (indexA <= mid && indexB <= to) {
            while (indexA <= mid && A[indexA] <= A[indexB]) {
                t[indext++] = A[indexA++];
            }
            if(indexA > mid) break;
            while (indexB <= to && A[indexA]>A[indexB]){
                t[indext++] = A[indexB++];
            }
        }
        while (indexA <= mid) {
            t[indext++] = A[indexA++];
        }
        while (indexB <= to) {
            t[indext++] = A[indexB++];
        }
        for (int i = 0; i < t.length; i++) {
            A[from + i] = t[i];
        }
    }

}

