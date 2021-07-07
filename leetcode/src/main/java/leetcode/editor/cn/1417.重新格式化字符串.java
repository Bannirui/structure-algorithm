import java.util.LinkedList;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 20:25:47
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 20:35:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1417 lang=java
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
class Solution {
    public String reformat(String s) {
        int letterCount = 0, digitCount = 0;
        Queue<Character> letterQueue = new LinkedList<>();
        Queue<Character> digitQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                digitCount++;
                digitQueue.offer(s.charAt(i));
            } else {
                letterCount++;
                letterQueue.offer(s.charAt(i));
            }
        }
        if (Math.abs(letterCount - digitCount) > 1) {
            return "";
        }
        char[] res = new char[s.length()];
        if (letterCount >= digitCount) {
            // 先放字母
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    res[i] = letterQueue.poll();
                } else {
                    res[i] = digitQueue.poll();
                }
            }
        } else {
            // 先放数字
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    res[i] = digitQueue.poll();
                } else {
                    res[i] = letterQueue.poll();
                }
            }
        }
        return new String(res);
    }
}
// @lc code=end
