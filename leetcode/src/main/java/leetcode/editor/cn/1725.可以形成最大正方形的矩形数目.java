import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 13:53:34
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 14:02:05
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1725 lang=java
 *
 * [1725] 可以形成最大正方形的矩形数目
 */

// @lc code=start
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            int length = Math.min(rectangle[0], rectangle[1]);
            count.put(length, count.getOrDefault(length, 0) + 1);
            maxLength = Math.max(maxLength, length);
        }
        return count.get(maxLength);
    }
}
// @lc code=end
