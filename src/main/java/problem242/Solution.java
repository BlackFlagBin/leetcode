package problem242;

/*
242. 有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

import java.util.HashMap;
import java.util.Objects;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < charS.length; i++) {
            Integer value = mapS.get(charS[i]);
            if (value == null) {
                mapS.put(charS[i], 1);
            } else {
                mapS.put(charS[i], ++value);
            }
        }

        for (int i = 0; i < charT.length; i++) {
            Integer value = mapT.get(charT[i]);
            if (value == null) {
                mapT.put(charT[i], 1);
            } else {
                mapT.put(charT[i], ++value);
            }
        }

        for (int i = 0; i < charS.length; i++) {
            if (!Objects.equals(mapS.get(charS[i]), mapT.get(charS[i]))) {
                return false;
            }
        }

        return true;
    }
}