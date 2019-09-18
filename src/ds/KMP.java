package ds;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {
        System.out.println(kmpSearch("abdadaewssaaabdadaewssaa","agctagcagctagct"));
    }

    static int kmpSearch(String s, String p)
    {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int pLen = p.length();
        int[] next = new int[pLen];
        getNext(p.toCharArray(),next);

        System.out.println(Arrays.toString(next));
        while (i < sLen && j < pLen)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    // 最长公共前缀后缀
    static void getNext(char[] p, int[] next)
    {
        int pLen = p.length;
        next[0] = -1;
        int k = -1; // p[k]表示前缀
        int j = 0;  // p[j]表示后缀
        while (j < pLen - 1)
        {
            if (k == -1 || p[j] == p[k])
            {
                ++k;
                ++j;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }
        }
    }

}
