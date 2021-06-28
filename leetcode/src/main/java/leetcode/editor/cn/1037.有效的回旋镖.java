import java.nio.channels.Pipe;

/*
 * @Author: dingrui
 * @Date: 2021-06-28 09:29:25
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 09:51:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */

// @lc code=start
class Solution {
    public boolean isBoomerang(int[][] points) {
        // 3个点 不同 不在一条直线
        // 斜率 (y2-y1)/(x2-x1) == (y3-y2)/(x3-x2) -> (y2-y1)*(x3-x2) == (y3-y2)*(x2-x1)
        if (((points[1][1] - points[0][1]) * (points[2][0] - points[1][0])) == ((points[2][1] - points[1][1])
                * (points[1][0] - points[0][0]))) {
            return false;
        }
        return true;
    }
}
// @lc code=end
