import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-09 15:33:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 16:54:29
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1560 lang=java
 *
 * [1560] 圆形赛道上经过次数最多的扇区
 */

// @lc code=start
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        // 赛道的经过次数 [0...n]赛道 统计的时候只统计[1...n]
        int[] count = new int[n + 1];
        for (int i = 0; i < rounds.length - 1; i++) {
            // 赛道[start, end) 最后加上最后一条赛道的经过次数1次
            int start = rounds[i];
            int end = rounds[i + 1];
            if (start > end) {
                // 多了一圈
                // [start...n)
                for (int j = start; j < (n + 1); j++) {
                    count[j]++;
                }
                // [0...end]
                for (int j = 1; j < end; j++) {
                    count[j]++;
                }
            } else {
                for (int j = start; j < end; j++) {
                    count[j]++;
                }
            }
        }
        count[rounds[rounds.length - 1]]++;
        int maxTimes = -1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int curTimes = count[i];
            if (curTimes == maxTimes) {
                res.add(i);
            } else if (curTimes > maxTimes) {
                maxTimes = curTimes;
                res.clear();
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end
