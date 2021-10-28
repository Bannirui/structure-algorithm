import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 有序
        // 小顶堆 当前元素 行索引 列索引
        Queue<int[]> smallHeap = new PriorityQueue<>((arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        // 遍历所有行 没一行的第一个元素都是最小的
        int ROWS = matrix.length;
        for (int i = 0; i < ROWS; i++) {
            int[] row = matrix[i];
            int curVal = row[0];
            int curROW = i;
            int curCol = 0;
            smallHeap.offer(new int[] { curVal, curROW, curCol });
        }
        // 消费队列中最小的元素 一直消费k-1个
        for (int i = 0; i < k - 1; i++) {
            int[] row = smallHeap.poll();
            int curRow = row[1];
            int curCol = row[2];
            // 总共ROWS列
            if (curCol != ROWS - 1) {
                int nextCol = curCol + 1;
                int nextVal = matrix[curRow][nextCol];
                smallHeap.offer(new int[] { nextVal, curRow, nextCol });
            }
        }
        // 第k个小的元素就是堆顶元素
        return smallHeap.poll()[0];
    }
}
// @lc code=end
