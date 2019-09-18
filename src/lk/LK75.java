package lk;

public class LK75 {

    public static void main(String[] args) {

    }

    public static void sort(int[] nums) {
        int n0 = 0, n1 = 0, n2 = 0;
        for (int num : nums) {
            if (num == 0) {
                n0++;
            } else if (num == 1) {
                n1++;
            } else {
                n2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (n0 > 0) {
                nums[i] = 0;
                n0--;
            } else if (n1 > 0) {
                nums[i] = 1;
                n1--;
            } else {
                nums[i] = 2;
                n2--;
            }
        }
    }

}
