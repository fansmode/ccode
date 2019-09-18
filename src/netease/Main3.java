package netease;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while (T > 0) {
            int N = input.nextInt();
            int ret = 0;
            while (N > 0) {
                int c = 0;
                String line = input.nextLine();
                if (line.equals("")) {
                    continue;
                }
                int len = line.length();
                int pos = 0;
                if (line.charAt(pos) == '#') {
                    while (line.charAt(pos) == '#') {
                        pos++;
                    }
                } else if (line.charAt(pos) == '+'){
                    ret = ret + 1;
                    c += 1;
                    pos = 5;
                }
                for (;pos < len;pos++){
                    if (line.charAt(pos) == '[') {
                        for (pos = pos + 1;pos < len - 1;pos++){
                            if (line.charAt(pos) == ']') {
                                while (line.charAt(pos) != ')' && pos < len - 1) {
                                    pos++;
                                }
                                pos++;
                                break;
                            }
                            c += 1;
                            ret++;
                        }
                    }
                    ret++;
                    c += 1;
                }
                System.out.println(c);
                N--;
            }
            System.out.println(ret);

            T--;
        }
    }

}
