import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 双指针
        // base case
        int len = 0;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        // len=1
        if (len == 1) {
            return 1;
        }
        // len>1
        int L = 0, R = 0;
        Set<Character> chSet = new HashSet();
        int maxLen = Integer.MIN_VALUE;
        while (L < len && R < len) {
            if (!chSet.contains(s.charAt(R))) {
                // R的字符没有与[L...R-1]重复 指针后移
                chSet.add(s.charAt(R++));
            } else {
                // R的字符在chSet中 也就是[L...R-1]
                int curLen = R - L;
                maxLen = Math.max(maxLen, curLen);
                // set重置
                chSet.remove(s.charAt(L));
                // 指针后移
                L++;
            }
        }
        // 最后一轮的不重复字符都在集合中 再次判断长度
        maxLen = Math.max(maxLen, chSet.size());
        return maxLen;
    }
}
// @lc code=end
