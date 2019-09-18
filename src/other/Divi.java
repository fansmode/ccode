package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Divi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            String a = input.next();
            int q = input.nextInt();
            delete(a,q);
        }
    }

    static void delete(String a, int k) {
        char[] chars = a.toCharArray();
        int len = chars.length;
        int te = k;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i] - '0');
        }
        while (k > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    list.remove(i);
                    break;
                }
            }
            k--;
        }
        while (list.size() > len - te) {
            list.remove(list.size() - 1);
        }
        for (Integer integer : list) {
            System.out.print(integer);
        }

    }

}
