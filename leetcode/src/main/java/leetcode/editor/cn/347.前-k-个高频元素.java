import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-17 16:29:31
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-18 11:14:10
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // key=num value=count
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 小根堆
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            // 频数升序
            return e1.getValue() - e2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        if (heap.isEmpty()) {
            return new int[0];
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
// @lc code=end
