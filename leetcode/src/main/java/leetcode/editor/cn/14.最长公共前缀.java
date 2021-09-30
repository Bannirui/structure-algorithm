/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // base case
        int len = 0;
        if (strs == null || (len = strs.length) == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // 找到长度最短字符串
        int minLen = Integer.MAX_VALUE;
        ;
        for (int i = 0; i < len; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        for (int i = 0; i < minLen; i++) {
            // 逐个比较每个单词每个i位置的字符
            char curChar = strs[0].charAt(i);
            for (int wdx = 0; wdx < len; wdx++) {
                if (curChar != strs[wdx].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(curChar);
        }
        return sb.toString();
    }
}
// @lc code=end
