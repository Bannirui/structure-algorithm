/*
 * @Author: dingrui
 * @Date: 2021-07-13 09:38:07
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-13 10:00:36
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1897 lang=java
 *
 * [1897] 重新分配字符使所有字符串都相等
 */

// @lc code=start
class Solution {
    public boolean makeEqual(String[] words) {
        int[] charCount = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                charCount[word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
