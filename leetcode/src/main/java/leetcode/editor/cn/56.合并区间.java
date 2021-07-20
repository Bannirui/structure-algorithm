import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-20 22:53:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 23:16:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        // int[] 两个元素按照首元素升序
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int preFir = res.get(res.size() - 1)[0];
            int preLast = res.get(res.size() - 1)[1];
            int curFir = intervals[i][0];
            int curLast = intervals[i][1];
            if (curFir <= preLast) {
                // 合并
                int[] newArr = new int[] { preFir, Math.max(preLast, curLast) };
                res.remove(res.size() - 1);
                res.add(newArr);
            } else {
                res.add(intervals[i]);
            }
        }
        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
// @lc code=end
