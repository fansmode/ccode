package lk;

import java.util.HashMap;
import java.util.Map;

public class LK1 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int dis = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (dis == nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
