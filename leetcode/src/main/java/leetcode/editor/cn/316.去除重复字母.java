import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: dingRui
 * @Date: 2021-08-06 09:55:25
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-06 17:22:11
 * @Description:
 */
/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        // 字符串中字符次数 可供消费的次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 辅助栈 小->大 单调
        Deque<Character> q = new LinkedList<>();
        // 记录栈中已经存储的字符 初始化全是false
        boolean[] exists = new boolean[26];
        // 遍历字符
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (exists[curChar - 'a']) {
                // 当前字符已经被收纳在栈中 统计次数更新
                count[curChar - 'a']--;
            } else {
                // 当前字符没有被收纳在栈中 从栈顶元素开始比较是否单调递增
                while (!q.isEmpty() && q.peekLast() > curChar && count[q.peekLast() - 'a'] > 0) {
                    // 栈顶元素比当前大 并且 栈顶元素次数还>1
                    // 出栈
                    char remove = q.pollLast();
                    // 更新记录表
                    exists[remove - 'a'] = false;
                }
                // 现在栈中为空或者元素单调递增 或者栈顶字符已经是最后一个再弹出以后就遇不到这个字符了
                q.offerLast(curChar);
                // 更新记录表
                exists[curChar - 'a'] = true;
                // 更新可消费字符数
                count[curChar - 'a']--;
            }
        }
        // 结束之后 栈中留存的拼接成字符串 先进先出
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pollFirst());
        }
        return sb.toString();
    }
}
// @lc code=end
