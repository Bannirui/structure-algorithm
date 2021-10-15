import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution
{
    public int[][] merge(int[][] intervals)
    {
        // 按照起点升序
        Arrays.sort(intervals, (o1, o2) ->
        {
            return o1[0] - o2[0];
        });
        Deque<int[]> dq = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++)
        {
            int[] cur = intervals[i];
            if (dq.isEmpty())
            {
                dq.offerLast(cur);
            }
            else
            {
                int[] old = dq.peekLast();
                if (cur[0] <= old[1])
                {
                    // 合并
                    dq.pollLast();
                    dq.offerLast(new int[] {old[0], Math.max(old[1], cur[1])});
                }
                else
                {
                    // 不需要合并
                    dq.offerLast(cur);
                }
            }
        }
        // 收集结果
        int size = dq.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++)
        {
            res[i] = dq.pollFirst();
        }
        return res;
    }
}
// @lc code=end
