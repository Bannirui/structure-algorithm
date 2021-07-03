/*
 * @Author: dingrui
 * @Date: 2021-07-03 10:42:42
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-03 11:15:00
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // destination >= start
        if (destination < start) {
            start = start ^ destination;
            destination = start ^ destination;
            start = start ^ destination;
        }
        int rDistance = 0, lDistance = 0;
        // [l, r)
        for (int i = start; i < destination; i++) {
            rDistance += distance[i];
        }
        // [r, l)
        for (int i = destination; i < (distance.length + start); i++) {
            lDistance += distance[i > (distance.length - 1) ? i % distance.length : i];
        }
        return Math.min(rDistance, lDistance);
    }
}
// @lc code=end
