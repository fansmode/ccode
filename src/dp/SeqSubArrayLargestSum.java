package dp;

/**
 * 连续子数组的最大和
 */
public class SeqSubArrayLargestSum {

    public static void main(String[] args) {
        int[] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(a));
    }

    static int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0],temp = array[0];
        for(int i = 1;i < array.length; i++){
            if(temp > 0){
                temp += array[i];
            }else{
                temp = array[i];
            }
            if(temp > max)
                max = temp;
        }
        return max;
    }

}
