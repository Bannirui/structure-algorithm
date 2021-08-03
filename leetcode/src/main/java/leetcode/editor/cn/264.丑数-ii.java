import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * @Author: dingRui
 * @Date: 2021-08-03 15:23:51
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 15:40:59
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] loadFactors = new int[] { 2, 3, 5 };
        Set<Long> cache = new HashSet<>();
        // 小根堆
        Queue<Long> smallHeap = new PriorityQueue<>();
        // 1是丑数
        smallHeap.offer(1L);
        cache.add(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 堆顶元素
            long smallest = smallHeap.poll();
            res = (int) smallest;
            for (int loadFactor : loadFactors) {
                long cur = smallest * loadFactor;
                if (!cache.contains(cur)) {
                    cache.add(cur);
                    smallHeap.offer(cur);
                }
            }
        }
        return res;
    }
}
// @lc code=end
