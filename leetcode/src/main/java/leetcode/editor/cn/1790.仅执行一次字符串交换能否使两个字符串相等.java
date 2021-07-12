/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:24:27
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:31:15
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1790 lang=java
 *
 * [1790] 仅执行一次字符串交换能否使两个字符串相等
 */

// @lc code=start
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // 两个字符串最多只有2个字符不相等
        int diffCount = 0;
        int[] total = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            total[s1.charAt(i) - 'a']++;
            total[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (total[i] != 0) {
                return false;
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 0 || diffCount == 2;
    }
}
// @lc code=end
