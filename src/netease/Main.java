package netease;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Q = input.nextInt();
        while (Q > 0) {
            int N = input.nextInt();
            int M = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            int w = input.nextInt();
            int T = input.nextInt();

            int[][] arr = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                arr[i][1] = 1;
                arr[i][M] = 1;
            }
            for (int i = 2; i <= M-1; i++) {
                arr[1][i] = 1;
                arr[N][i] = 1;
            }

            int ret = 0;

            while (T >= 0) {
                switch (w) {
                    case 0:
                        if (x - 1 == 1 && y - 1 == 1) {
                            ret = ret + 2;
                            w = 2;
                            x += 1;
                            y += 1;
                        } else if(y - 1 == 1){
                            ret += 1;
                            w = 1;
                            x = x - 1;
                            y = y + 1;
                        } else if (x - 1 == 1) {
                            ret += 1;
                            w = 3;
                            x = x + 1;
                            y = y - 1;
                        } else {
                            x = x -1;
                            y = y - 1;
                        }
                        break;
                    case 1:
                        if (x - 1 == 1 && y + 1 == M) {
                            ret = ret + 2;
                            w = 3;
                            x += 1;
                            y -= 1;
                        } else if(x - 1 == 1){
                            ret += 1;
                            w = 2;
                            x = x + 1;
                            y = y + 1;
                        } else if (y + 1 == M) {
                            ret += 1;
                            w = 0;
                            x = x - 1;
                            y = y - 1;
                        } else {
                            x = x - 1;
                            y = y + 1;
                        }
                        break;
                    case 2:
                        if (x + 1 == N && y + 1 == M) {
                            ret = ret + 2;
                            w = 0;
                            x -= 1;
                            y -= 1;
                        } else if(x + 1 == N){
                            ret += 1;
                            w = 1;
                            x = x - 1;
                            y = y + 1;
                        } else if (y + 1 == M) {
                            ret += 1;
                            w = 3;
                            x = x + 1;
                            y = y - 1;
                        } else {
                            x = x + 1;
                            y = y + 1;
                        }
                        break;
                    case 3:
                        if (x + 1 == N && y - 1 == 1) {
                            ret = ret + 2;
                            w = 1;
                            x -= 1;
                            y += 1;
                        } else if(x + 1 == N){
                            ret += 1;
                            w = 0;
                            x = x - 1;
                            y = y - 1;
                        } else if (y - 1 == 1) {
                            ret += 1;
                            w = 2;
                            x = x + 1;
                            y = y + 1;
                        } else {
                            x = x + 1;
                            y = y - 1;
                        }
                        break;
                }
                T--;
            }

            System.out.println(ret);
            Q--;
        }
    }

}
