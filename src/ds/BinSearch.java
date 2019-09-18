package ds;

public class BinSearch {

    public static int binarySearch(int[] s, int target) {
        int l = 0, r = s.length - 1;
        int mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (s[mid] == target) {
                return mid;
            }
            if (target > s[mid]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     *二分查第一个出现的
     */
    public static int binarySear(int[] s, int target) {
        if (s.length == 0) {
            return -1;
        }
        int l = 0, r = s.length - 1;
        int mid = -1;
        while (l + 1 < r) {
            mid = l + (r - l) / 2; //不会溢出
            if (s[mid] == target) {
                r = mid;
            } else if (s[mid] < target){
                l = mid;
            } else if (s[mid] > target) {
                r = mid;
            }
        }

        if (s[l] == target) {
            return l;
        }
        if (s[r] == target) {
            return r;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] test = {1,5,8,9,12,19,19,19,19,19,19,19,68,98};
        System.out.println(binarySearch(test,19));
    }

}
