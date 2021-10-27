import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计词频
        Map<Integer, Integer> cntMap = new HashMap<>();
        // 遍历元素
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        // 堆排序 小根堆
        Queue<Map.Entry<Integer, Integer>> smallHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            smallHeap.offer(entry);
            if (smallHeap.size() > k) {
                // poll
                smallHeap.poll();
            }
        }
        if (smallHeap.isEmpty()) {
            return null;
        } else {
            int size = smallHeap.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = smallHeap.poll().getKey();
            }
            return res;
        }
    }
}
// @lc code=end
