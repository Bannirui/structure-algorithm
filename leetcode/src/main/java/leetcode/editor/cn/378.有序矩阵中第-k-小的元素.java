import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingRui
 * @Date: 2021-07-22 22:29:41
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-17 10:44:59
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 小顶堆 [行索引, 列索引 ,值]
        Queue<int[]> smallQueue = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        // 矩阵中每一行首列元素
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        for (int row = 0; row < ROWS; row++) {
            smallQueue.offer(new int[] { row, 0, matrix[row][0] });
        }
        // 取k-1个元素 第k个元素留在堆顶
        for (int count = 0; count < k - 1; count++) {
            int[] arr = smallQueue.poll();
            if (arr[1] != COLS - 1) {
                int curRow = arr[0];
                int curCol = arr[1];
                smallQueue.offer(new int[] { curRow, curCol + 1, matrix[curRow][curCol + 1] });
            }
        }
        // 队列首元素
        return smallQueue.peek()[2];
    }
}
// @lc code=end
