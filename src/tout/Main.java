package tout;

        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int coin = 64;
        N = 1024 - N;
        while (coin != 0) {
            count += N / coin;
            N %= coin;
            coin /= 4;
        }
        System.out.println(count);
    }

}
