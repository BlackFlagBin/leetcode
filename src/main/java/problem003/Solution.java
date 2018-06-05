package problem003;

/*
3. 无重复字符的最长子串

给定一个字符串，找出不含有重复字符的最长子串的长度。

示例：

给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int[] freq = new int[256];
        //[l ... r] 存放无重复子串
        int l = 0;
        int r = -1;
        int result = 0;

        while (l < charArray.length) {
            //如果r+1位置的字符与子串不重复
            if (r + 1 < charArray.length && freq[charArray[r + 1]] == 0) {
                freq[charArray[++r]]++;
            } else {
                freq[charArray[l++]]--;
            }

            result = Math.max(result, r - l + 1);

        }

        return result;
    }
}