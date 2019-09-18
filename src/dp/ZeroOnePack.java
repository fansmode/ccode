package dp;

public class ZeroOnePack {

    public static void main(String[] args) {
        int[] weight = {0, 2, 2, 6, 5, 4};
        int[] price = {0, 6, 3, 5, 4, 6};
        int capacity = 10;
        System.out.println(packTreasure(weight,price,capacity));
    }

    static long packTreasure(int[] weight, int[] price, int capacity) {
        long[] res = new long[capacity + 1];
        for (int i = 0;i <= capacity; i++){
            if (weight[0] < capacity) {
                res[i] = 0;
            }else {
                res[i] = price[0];
            }
        }

        for (int i = 1;i < weight.length; i++){
            for (int j = capacity;j >= weight[i]; j--){
                res[j] = Math.max(res[j],res[j - weight[i]] + price[i]);
            }
        }
        return res[capacity];
    }


}
