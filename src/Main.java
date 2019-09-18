import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int q = cin.nextInt();
        for (int i = 0; i < q; i++) {
            int l = cin.nextInt();
            int r = cin.nextInt();
            if ((r - l + 1) % 2 == 0) {
                if (l % 2 == 1) {
                    System.out.println((r - l + 1) / 2);
                } else {
                    System.out.println((-1) * (r - l + 1) / 2);
                }
            } else if (r == l) {
                System.out.println((l % 2 == 0) ? 2 * l : (-1) * 2 * l);
            } else {
                if (l % 2 == 1) {
                    System.out.println((r - l) / 2 - r);
                } else {
                    System.out.println((-1) * (r - l) / 2 + r);
                }
            }
        }

    }
}
