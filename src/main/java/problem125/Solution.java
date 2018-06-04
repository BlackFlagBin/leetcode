package problem125;

/*
125. 验证回文串

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 */

class Solution {
    public boolean isPalindrome(String s) {
        //左右指针对撞

       char[] chars = s.toLowerCase().toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {

            if (!(Character.isLetter(chars[l]) || Character.isDigit(chars[l]))) {
                l++;
                continue;
            }

            if (!(Character.isLetter(chars[r]) || Character.isDigit(chars[r]))) {
                r--;
                continue;
            }

            if (chars[l] != chars[r]) {
                return false;
            }

            l++;
            r--;

        }
        return true;
    }
}