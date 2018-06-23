package problem017;

import java.util.ArrayList;
import java.util.List;
/*
17. 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

class Solution {
    private String[]     letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result    = new ArrayList();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        findCombination(digits, 0, "");
        return result;
    }

    private void findCombination(String digits, int index, String lastStr) {
        if (index == digits.length()) {
            result.add(lastStr);
            return;
        }

        char c = digits.charAt(index);
        String s = letterMap[c - '0'];
        for (int i = 0; i < s.length(); i++) {
            findCombination(digits, index + 1, lastStr + s.charAt(i));
        }

    }
}