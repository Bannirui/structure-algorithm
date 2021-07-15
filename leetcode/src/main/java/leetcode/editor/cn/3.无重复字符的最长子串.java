import java.util.HashSet;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 14:07:44
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 14:26:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> map = new HashSet<>();
        // 右边界
        int rightIndex = -1;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // 当前起始位置
            // 从i-1遍历过来的 移除s[i-1]
            if (i != 0) {
                map.remove(s.charAt(i - 1));
            }
            // s[i...rightIndex]
            while (rightIndex + 1 < s.length() && !map.contains(s.charAt(rightIndex + 1))) {
                rightIndex++;
                map.add(s.charAt(rightIndex));
                // 结算时机
                maxLen = Math.max(maxLen, rightIndex - i + 1);
            }
        }
        return maxLen;
    }
}
// @lc code=end
