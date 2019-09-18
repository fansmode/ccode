package niuke;

public class OneNumber {

    public static void main(String[] args) {
        System.out.println(new OneNumber().NumberOf2(10));
    }

    public int NumberOf1(int n) {
        int res = 0;
        for(int i = 0;i < 32; i ++){
            if(((1 << i) & n )!= 0){
                res ++;
            }
        }
        return res;
    }

    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }

}
