import java.util.Arrays;
import java.util.Scanner;

public class qq {

    public static void main2(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int L = input.nextInt();
        Range[] eyes = new Range[n];
        for (int i = 0; i < n; i++) {
            eyes[i] = new Range(input.nextInt(), input.nextInt());
        }
        Arrays.sort(eyes);
        if (eyes[0].x != 0) {
            System.out.println(-1);
            return;
        }

        int max = 0, currentLength = 0, i = 0, count = 0;
        while (i < n) {
            if (eyes[i].x == eyes[i].y) {
                i++;
                continue;
            }
            if (eyes[i].x <= currentLength && eyes[i].y > max) {
                max = eyes[i].y;
                i++;
            } else {
                count++;
                currentLength = max;
            }
        }
        if (max < L)
            System.out.println(-1);
        System.out.println(count + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] w = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = input.nextInt();
        }
        for (int i = n-1;i>=0;i--){
            //left
            int left = 0;
            int j = i - 1;
            if (j >= 0) {
                left++;
            }
            while (j >= 0) {
                if (j - 1 >= 0 && (w[j] < w[j - 1]||w[j - 1]<w[i])) {
                    left++;
                    j--;
                } else {
                    break;
                }
            }
            res[i] = left;
            //right
            int right = 0;
            j = i + 1;
            if (j < n) {
                right++;
            }
            while (j <n ) {
                if (j + 1 < n && (w[j] < w[j + 1]||w[j+1] < w[i])) {
                    right++;
                    j++;
                } else {
                    break;
                }
            }
            res[i] = left + right + 1;
        }
        System.out.println(Arrays.toString(res));
    }

    static class Range implements Comparable {
        int x;
        int y;

        public Range(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Range r = (Range) o;
            return this.x - r.x;
        }
    }


}
