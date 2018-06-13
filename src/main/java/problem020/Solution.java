package problem020;

/*
20. 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //利用栈的特性进行匹配
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[' || chars[i] == '{' || chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else {
                    char matchChar;
                    if (chars[i] == ']') {
                        matchChar = '[';
                    } else if (chars[i] == '}') {
                        matchChar = '{';
                    } else {
                        matchChar = '(';
                    }
                    Character popChar = stack.pop();
                    if (popChar != matchChar) {
                        return false;
                    }
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}