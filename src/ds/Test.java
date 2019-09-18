package ds;

public class Test {

    public static void main(String[] args) {
        System.out.println(perfectNumberCheck(28));
        System.out.println(perfectNumberCheck(6));
        System.out.println(perfectNumberCheck(10));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int perfectNumberCheck(int n)
    {
        // Check if N is perfect or not
        // Return 1 or 0
        // INSERT YOUR CODE HERE
        if(n == 1) return 1;
        int sum = 1;
        int temp = 2;
        while (temp <= n) {
            while (n % temp != 0 && temp < n)
                temp++;
            if (temp == n) {
                break;
            }
            if (n % temp == 0) {
                sum += temp;
            }
            temp ++;
        }
//        for (int i = 2;i<= Math.sqrt(n) ;i ++ ){
//            if(n % i == 0){
//                sum = sum + i + n/i;
//                System.out.println(i + " " + n/i);
//            }
//        }
        if(sum == n){
            return 1;
        }
        return 0;
    }

    int check(String[] arr) {

        for (int i = arr.length - 1;i > 0; i--){
            if (arr[i].charAt(0) != arr[i - 1].charAt(arr[i - 1].length() - 1)) {
                return -1;
            }
        }

        return 0;
    }

}

