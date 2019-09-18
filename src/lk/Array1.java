package lk;

import java.util.Arrays;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * <p>
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
 */
public class Array1 {

    public static void main(String[] args) {
        int[] a = {1,0};
        System.out.println( dominantIndex(a));
        System.out.println(pivotIndex(a));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }
        int sumOfLeft = 0;
        for (int i = 0; i <= len-1; i++) {
            if (sumOfLeft * 2 == sum - nums[i]) {
                return i;
            }
            sumOfLeft += nums[i];
        }
        return -1;
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1)
            return 0;
        int maxIdx = 0;
        int secondNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) {
                secondNum = nums[maxIdx];
                maxIdx = i;
            } else {
                if (nums[i] > secondNum) {
                    secondNum = nums[i];
                }
            }
        }
        return secondNum * 2 <= nums[maxIdx] ? maxIdx : -1;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
