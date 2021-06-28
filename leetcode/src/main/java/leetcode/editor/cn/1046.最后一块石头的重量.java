import java.util.BitSet;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * @Author: dingrui
 * @Date: 2021-06-28 09:52:25
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 11:02:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        // 大根堆
        PriorityQueue<Integer> bigHeap = new PriorityQueue<Integer>((o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < stones.length; i++) {
            bigHeap.add(stones[i]);
        }
        // 每次出队两个最大的
        while (bigHeap.size() != 0) {
            if (bigHeap.size() == 1) {
                // 如果只剩一个元素了 那么就是结果
                break;
            } else {
                int firMax = bigHeap.poll();
                int secMax = bigHeap.poll();
                if (firMax == secMax) {
                    // 全部粉碎
                } else {
                    bigHeap.add(firMax - secMax);
                }
            }
        }
        return bigHeap.size() == 0 ? 0 : bigHeap.poll();
    }
}
// @lc code=end
