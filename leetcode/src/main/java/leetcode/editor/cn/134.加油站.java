/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 遍历 以i为起始点
        int len = gas.length;
        int i = 0;
        while (i < len) {
            // 以i为起点 能走过的站点数量(不包含当前节点)
            int curCnt = 0;
            // 总共获取的汽油 总过消耗的汽油
            int gasSum = 0, costSum = 0;
            while (curCnt < len) {
                // 环形 取模定位脚标
                int idx = (i + curCnt) % len;
                gasSum += gas[idx];
                costSum += cost[idx];
                if (costSum > gasSum) {
                    // 入不敷出 以i为节点能够走的最远
                    break;
                }
                curCnt++;
            }
            if (curCnt == len) {
                // 走了一圈了
                return i;
            } else {
                // 以i为节点无法走一圈 调整下一个节点继续试错
                i = i + curCnt + 1;
            }
        }
        return -1;
    }
}
// @lc code=end
