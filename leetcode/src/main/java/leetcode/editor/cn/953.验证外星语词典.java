/*
 * @Author: dingrui
 * @Date: 2021-06-29 17:13:25
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 09:41:42
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // 两两单词有序 单词字母有序
        // order 字符的相对顺序
        int[] orderCache = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderCache[order.charAt(i) - 'a'] = i;
        }

        loop: for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String next = words[i + 1];
            // pre < next pre字符<=next字符
            for (int j = 0; j < Math.min(pre.length(), next.length()); j++) {
                char preChar = pre.charAt(j);
                char nextChar = next.charAt(j);
                // 第一个不相等的字符
                if (preChar != nextChar) {
                    int preCharOrder = orderCache[preChar - 'a'];
                    int nextCharOrder = orderCache[nextChar - 'a'];
                    if (preCharOrder > nextCharOrder) {
                        return false;
                    }
                    continue loop;
                }
            }
            // 长度相等的时候 pre<next 长度不等的时候短的在前面
            if (pre.length() > next.length()) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
