import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // base case
        int len = 0;
        if (intervals == null || (len = intervals.length) == 0) {
            return 0;
        }
        // // 区间左边界升序
        // Arrays.sort(intervals, (o1, o2) -> {
        // return o1[0] - o2[0];
        // });
        // // dp[i]语义: 以第i个区间的右边界结尾的不重叠最大数量
        // int[] dp = new int[len];
        // Arrays.fill(dp, 1);
        // for (int i = 1; i < len; i++) {
        // for (int j = 0; j < i; j++) {
        // if (intervals[j][1] <= intervals[i][0]) {
        // // 第j个区间的右边界<=第i个区间的左边界 -> 两个区间不重合
        // dp[i] = Math.max(dp[i], dp[j] + 1);
        // }
        // }
        // }
        // // dp中找出最大值就是保留的区间
        // int keep = Arrays.stream(dp).max().getAsInt();

        // 区间右边界升序
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        // 区间右边界
        int curRight = intervals[0][1];
        // 形成部重合区间的数量
        int keep = 1;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= curRight) {
                // 找到了可以拼接成不重合的区间
                keep++;
                curRight = intervals[i][1];
            }
        }
        // 要移除的区间数量
        return len - keep;
    }
}
// @lc code=end
