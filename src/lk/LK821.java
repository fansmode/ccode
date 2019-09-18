package lk;

import java.util.ArrayList;
import java.util.List;

public class LK821 {

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        int[] r = shortestToChar2(S, C);
        for (int i : r) {
            System.out.print(i + ",");
        }

    }

    public static int[] shortestToChar2(String S, char C) {

        char[] sArray = S.toCharArray();
        int[] res = new int[sArray.length];

        int start = -9999999, end = 9999999, s = 0;

        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == C) {
                res[i] = 0;
                for (int l = i + 1; l < sArray.length; l++) {
                    if (sArray[l] == C) {
                        end = l;
                        break;
                    }
                }
                if (start < 0) {
                    s = i;
                }
                start = i;
            } else {
                res[i] = Math.min(Math.abs(start - i), Math.abs(end - i));
            }
        }
        for (int j = 0; j <= s; j++) {
            res[j] = s - j;
        }
        for (int k = end; k < res.length; k++) {
            res[k] = k - end;
        }
        return res;
    }

    public int[] shortestToChar(String S, char C) {

        char[] sArray = S.toCharArray();
        int[] res = new int[sArray.length];
        List<Integer> hitIndexs = new ArrayList<>();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == C) {
                hitIndexs.add(i);
            }
        }
        for (int i = 0; i < sArray.length; i++) {
            res[i] = min(i, (ArrayList<Integer>) hitIndexs);
        }
        return res;
    }

    public int min(int index, ArrayList<Integer> hitIndexs) {
        int minDis = 10000;
        for (Integer hitIndex : hitIndexs) {
            int diff = Math.abs(index - hitIndex);
            if (diff < minDis) {
                minDis = diff;
            }
        }
        return minDis;
    }

}
