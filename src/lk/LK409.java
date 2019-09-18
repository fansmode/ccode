package lk;

import java.util.HashSet;
import java.util.Set;

public class LK409 {

    public static void main(String[] args) {

    }

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     */
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> hashSet = new HashSet<>();
        char[] ss = s.toCharArray();
        int ret = 0;
        for (int i = 0; i < ss.length; i++) {
            if (!hashSet.contains(ss[i])) {
                hashSet.add(ss[i]);
            } else {
                hashSet.remove(ss[i]);
                ret++;
            }
        }
        return hashSet.isEmpty() ? ret * 2 : ret * 2 + 1;
    }

}
