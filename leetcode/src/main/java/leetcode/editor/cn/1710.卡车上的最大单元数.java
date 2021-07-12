import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 11:13:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 11:35:31
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1710 lang=java
 *
 * [1710] 卡车上的最大单元数
 */

// @lc code=start
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 按照每个箱子的单元降序
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        for (int[] boxType : boxTypes) {
            heap.offer(boxType);
        }
        int res = 0;
        int leftTrucks = truckSize;
        while (leftTrucks > 0 && !heap.isEmpty()) {
            int[] curBoxType = heap.poll();
            int needBoxs = Math.min(leftTrucks, curBoxType[0]);
            res += (needBoxs * curBoxType[1]);
            leftTrucks -= needBoxs;
        }
        return res;
    }
}
// @lc code=end
