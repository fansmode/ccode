package tencent_qz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Consumer> cs = new ArrayList<>(n + 1);
        for (int i = 1; i <= n ; i++) {
            cs.add(new Consumer(input.nextInt(), input.nextInt()));
        }
        Collections.sort(cs, new Comparator<Consumer>() {
            @Override
            public int compare(Consumer o1, Consumer o2) {
                return (o1.b - o1.a) - (o2.b - o2.a);
            }
        });
        int res = 0;
        int j = 1;
        for (Consumer c : cs) {
            res +=c.a * (j - 1) + c.b * (n - j);
            j++;
        }
        System.out.println(res);

    }

    static class Consumer {
        int a;
        int b;

        Consumer(int a,int b) {
            this.a = a;
            this.b = b;
        }
    }

}