import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 16:08:57
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 16:18:07
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1539 lang=java
 *
 * [1539] 第 k 个缺失的正整数
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        // 小顶堆
        Queue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> {
            return o1 - o2;
        });
        // 已经存在的数
        Set<Integer> exists = new HashSet<>();
        for (int num : arr) {
            exists.add(num);
        }
        for (int i = 1; i <= 2000; i++) {
            if (!exists.contains(i)) {
                // 缺失的数
                heap.offer(i);
            }
        }
        while (k != 1) {
            heap.poll();
            k--;
        }
        return heap.poll();
    }
}
// @lc code=end
