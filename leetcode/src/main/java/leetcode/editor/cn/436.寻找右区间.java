import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // 暴力法
        return this.force(intervals);
    }

    // 暴力求解
    private int[] force(int[][] intervals) {
        // base case
        int len = 0;
        if (intervals == null || (len = intervals.length) == 0) {
            return null;
        }
        int[] res = new int[len];
        Arrays.fill(res, -1);
        // 遍历区间
        for (int i = 0; i < len; i++) {
            int minLeft = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < minLeft) {
                    // 找到了一个符合条件区间
                    minLeft = intervals[j][0];
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
// @lc code=end
