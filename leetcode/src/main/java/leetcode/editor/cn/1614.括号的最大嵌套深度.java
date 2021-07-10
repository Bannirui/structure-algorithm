import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 14:45:02
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 15:08:27
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int pair = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pair++;
                res = Math.max(res, pair);
            } else if (s.charAt(i) == ')') {
                pair--;
            }
        }
        return res;
    }
}
// @lc code=end
