import java.sql.SQLWarning;

/*
 * @lc app=leetcode.cn id=1668 lang=java
 *
 * [1668] 最大重复子字符串
 */

// @lc code=start
class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int res = 0;
        while (sequence.contains(sb.toString())) {
            res++;
            sb.append(word);
        }
        return res;
    }
}
// @lc code=end
