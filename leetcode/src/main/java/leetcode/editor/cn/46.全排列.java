import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution
{

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums)
    {
        // 创建数组 默认赋值false
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        List<Integer> path = new ArrayList<>();
        this.traceBack(nums, used, path);
        return this.res;
    }

    private void traceBack(int[] nums, boolean[] used, List<Integer> path)
    {
        // base case
        if (path.size() == nums.length)
        {
            // 收集结果
            List<Integer> tmpRes = new ArrayList<>(path);
            this.res.add(tmpRes);
            return;
        }
        // 找没用过的数字
        for (int i = 0; i < nums.length; i++)
        {
            if (!used[i])
            {
                // 该数字没用过
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                used[i] = true;
                // 递归
                this.traceBack(nums, used, newPath);
                // 现场还原
                used[i] = false;
            }
        }
    }
}
// @lc code=end
