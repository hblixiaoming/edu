package com.lxm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(t.length());
        int l = 0, h = 0;
        for (int i = 0, j = 0; i < j && j < s.length(); ) {
            char c = s.charAt(j);
            int k = 0;
            for (; k < t.length(); k++) {
                if (t.charAt(k) == c) {
                    map.put(c, j);
                    break;
                }
            }
            if (k < t.length() && map.size() == t.length()) {

            } else {
                j++;
            }
        }
        return s;
    }

    private Integer getMinIdx(Map<Character, Integer> map){
        int min = Integer.MAX_VALUE;
        //for(Integer )
        return 0;
    }
}
