import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            cntMap.put(curChar, cntMap.getOrDefault(curChar, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (cntMap.getOrDefault(s.charAt(i), 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
