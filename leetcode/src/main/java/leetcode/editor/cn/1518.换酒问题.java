import java.util.LinkedList;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 15:34:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 15:44:25
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1518 lang=java
 *
 * [1518] 换酒问题
 */

// @lc code=start
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // 队列
        Queue<Integer> helpQueue = new LinkedList<>();
        int res = numBottles;
        for (int i = 0; i < numBottles; i++) {
            helpQueue.offer(1);
        }
        while (!helpQueue.isEmpty() && helpQueue.size() >= numExchange) {
            // 喝完numExchange换酒
            for (int i = 0; i < numExchange; i++) {
                helpQueue.poll();
            }
            helpQueue.offer(1);
            res++;
        }
        return res;
    }
}
// @lc code=end
