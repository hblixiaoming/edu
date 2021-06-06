package com.lxm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>(t.length());
        for (int c = 0; c < t.length(); c++) {
            tMap.compute(t.charAt(c), (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
        int l = 0, h = Integer.MAX_VALUE;
        Map<Character, Integer> sMap = new HashMap<>(t.length());
        for (int i = 0, j = 0; j < s.length(); ) {
            char c = s.charAt(j);
            int p = 0;
            for (; p < t.length(); p++) {
                if (t.charAt(p) == c) {
                    sMap.compute(c, (k, v) -> {
                        if (v == null) {
                            return 1;
                        } else {
                            return v + 1;
                        }
                    });
                    break;
                }
            }
            if (p < t.length() && contains(tMap, sMap)) {
                do {
                    char nc = s.charAt(i);
                    if (sMap.containsKey(nc)) {
                        sMap.put(nc, sMap.get(nc) - 1);
                    }
                    if (!contains(tMap, sMap)) {
                        break;
                    }
                    i++;
                } while (true);
                if ((j - i) < (h - l)) {
                    h = j;
                    l = i;
                }
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (l > s.length() || h > s.length()) {
            return "";
        } else {
            return s.substring(l, h + 1);
        }
    }

    private boolean contains(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (char c : tMap.keySet()) {
            if (sMap.get(c) == null || tMap.get(c)>sMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question76 question76 = new Question76();
        System.out.println(question76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
