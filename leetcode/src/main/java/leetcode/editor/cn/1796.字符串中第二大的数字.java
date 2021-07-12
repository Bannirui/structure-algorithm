import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:39:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:46:01
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1796 lang=java
 *
 * [1796] 字符串中第二大的数字
 */

// @lc code=start
class Solution {
    public int secondHighest(String s) {
        // 大顶堆
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = (int) (s.charAt(i) - '0');
                if (!heap.contains(num)) {
                    heap.offer(num);
                }
            }
        }
        if (heap.size() < 2) {
            return -1;
        }
        heap.poll();
        return heap.poll();
    }
}
// @lc code=end
