package lk;

public class LK53 {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (ans < sum) {
                ans = sum;
            }
        }
        return ans;
    }

}
