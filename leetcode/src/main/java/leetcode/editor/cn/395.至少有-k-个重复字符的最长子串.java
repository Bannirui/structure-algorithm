/*
 * @Author: dingRui
 * @Date: 2021-08-23 22:29:03
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-24 21:30:22
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k < 0) {
            throw new RuntimeException();
        }
        return this.dfs(s, 0, s.length() - 1, k);
    }

    // 在s中[start...end]中至少有k个重复字符的最长字符串长度
    private int dfs(String s, int start, int end, int k) {
        // base case
        int[] count = new int[26];
        // 统计字符出现次数
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        // a-z中第一个出现次数不是k 只要包含这个字符的所有子串一定不符合要求
        char diff = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] > 0 && count[j] < k) {
                diff = (char) ('a' + j);
                break;
            }
        }
        // diff=0意味着整个字符串中所有的字符都满足要求
        if (diff == 0) {
            return end - start + 1;
        }
        // 避开diff字符进行递归
        int res = 0;
        int i = start;
        while (i <= end) {
            // 子问题的起点
            while (i <= end && s.charAt(i) == diff) {
                i++;
            }
            if (i > end) {
                // 越界
                break;
            }
            // 子问题起点
            int subStart = i;
            while (i <= end && s.charAt(i) != diff) {
                i++;
            }
            // 此刻i就是diff字符 子问题的终点就是diff前一个字符
            int subEnd = i - 1;
            int subLen = this.dfs(s, subStart, subEnd, k);
            res = Math.max(res, subLen);
        }
        return res;
    }
}
// @lc code=end
