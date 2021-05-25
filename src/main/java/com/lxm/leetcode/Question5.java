package com.lxm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question5 {

    /**
     * 暴力破解法从最长的子串开始依次判断是否是回文子串直到找到一个合适的为止
     *
     * @param s
     * @return
     */
    public String solution1(String s) {
        if (s.length() == 1) {
            return s;
        }
        for (int l = s.length(); l > 0; l--) {
            for (int i = 0, j = i + l; i < s.length() && j <= s.length(); ) {
                String substr = s.substring(i, j);
                if (isPlainDromic(substr)) {
                    return substr;
                }
                i++;
                j = i + l;
            }

        }
        return null;
    }

    /**
     * 判断一个字符串是否是回文串
     *
     * @param substr
     * @return
     */
    private boolean isPlainDromic(String substr) {
        if (substr.length() == 1) {
            return true;
        }
        int mid = substr.length() / 2;
        for (int i = 0, j = substr.length() - 1; i <= mid && j >= mid; i++, j--) {
            if (substr.charAt(i) != substr.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public String solution2(String s) {
        if (s.length() == 1) {
            return s;
        }
        Map<String, Integer> map = new HashMap<>();
        map = handleSub(s, map);
        return map.keySet().stream().findFirst().get();
    }

    public Map<String, Integer> handleSub(String sub, Map<String, Integer> map) {
        if (sub.length() == 1) {
            if (map.isEmpty()) {
                map.put(sub, 1);
            }
        }
        int mid = sub.length() / 2;
        for (int i = mid, j = i + 1; i >= 0 && j < sub.length(); i--, j++) {
            if (sub.charAt(i) != sub.charAt(j)) {
                Optional<Map.Entry<String, Integer>> entry = map.entrySet().stream().findFirst();
                if (entry.isPresent()) {
                    int max = entry.get().getValue();
                    if ((j - i) > max) {
                        map.put(sub.substring(i, j), (j - i));
                    }
                }
                map = handleSub(sub.substring(0, mid), map);
                map = handleSub(sub.substring(mid, sub.length()), map);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Question5 question5 = new Question5();
        //System.out.println(question5.solution1("bb"));
        System.out.println(question5.solution2("bb"));
    }
}
