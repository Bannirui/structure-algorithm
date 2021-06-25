import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountedCompleter;

/*
 * @Author: dingrui
 * @Date: 2021-06-23 09:42:52
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 23:42:59
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        // 分组计数
        List<Integer> counts = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int curCount = 0;
            char curChar = s.charAt(index);
            while (index < s.length() && s.charAt(index) == curChar) {
                curCount++;
                index++;
            }
            counts.add(curCount);
        }
        int res = 0;
        for (int i = 1; i < counts.size(); i++) {
            res += Math.min(counts.get(i - 1), counts.get(i));
        }
        return res;
    }
}
// @lc code=end
