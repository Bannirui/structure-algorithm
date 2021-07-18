import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-18 10:40:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-18 10:52:30
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 频数 key=word value=count
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        // 小根堆 前k个比较器
        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((e1, e2) -> {
            return e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue();
        });
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(0, heap.poll().getKey());
        }
        return res;
    }
}
// @lc code=end
