package design;

import java.util.Stack;

/**
 * @Author lixiang
 * @Date 2021/3/18
 * 时间复杂度 空间复杂度 都是 O(n)O(n)
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {    // 左括号的索引，入栈
                stack.push(i);
            } else {   // 遍历到右括号
                stack.pop();  // 栈顶的左括号被匹配，出栈
                if (stack.empty()) {// 栈空了
                    stack.push(i); // 入栈充当参照
                } else {
                    // 计算有效连续长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
