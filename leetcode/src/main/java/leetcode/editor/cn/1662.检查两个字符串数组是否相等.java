import java.util.LinkedList;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 19:47:42
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 19:52:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1662 lang=java
 *
 * [1662] 检查两个字符串数组是否相等
 */

// @lc code=start
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // 队列
        Queue<Character> helpQueue = new LinkedList<>();
        for (String word : word1) {
            for (int i = 0; i < word.length(); i++) {
                helpQueue.offer(word.charAt(i));
            }
        }
        // 匹配第二个字符串
        for (String word : word2) {
            for (int i = 0; i < word.length(); i++) {
                if (helpQueue.isEmpty()) {
                    return false;
                } else {
                    if (word.charAt(i) != helpQueue.poll()) {
                        return false;
                    }
                }
            }
        }
        return helpQueue.isEmpty();
    }
}
// @lc code=end
