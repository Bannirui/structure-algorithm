import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-18 16:19:42
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-18 17:08:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1738 lang=java
 *
 * [1738] 找出第 K 大的异或坐标值
 */

// @lc code=start
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        // [r][c]的异或值=[r-1][c]异或值^[r][0...c]
        int[][] cache = new int[matrix.length][matrix[0].length];
        // [r][c]的异或值=[r][c-1]异或值^[r][c]
        int preXor = 0;
        for (int c = 0; c < matrix[0].length; c++) {
            cache[0][c] = preXor ^ matrix[0][c];
            preXor = cache[0][c];
        }
        for (int r = 1; r < matrix.length; r++) {
            preXor = 0;
            for (int c = 0; c < matrix[0].length; c++) {
                preXor ^= matrix[r][c];
                cache[r][c] = cache[r - 1][c] ^ preXor;
            }
        }

        // 小顶堆
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            // 升序
            return o1 - o2;
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heap.offer(cache[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        // 堆顶最小值
        return heap.poll();
    }
}
// @lc code=end
