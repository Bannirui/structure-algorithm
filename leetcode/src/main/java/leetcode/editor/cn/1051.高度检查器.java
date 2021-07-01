import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-01 13:24:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 13:31:40
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        int[] help = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            help[i] = heights[i];
        }
        Arrays.sort(help);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (help[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
