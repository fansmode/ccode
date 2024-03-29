package lk;

/**
 * 80. 删除排序数组中的重复项 II
 *
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class LK80 {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 0,len = nums.length;i < len; i ++){
            if(k < 2 || nums[i] > nums[k-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
