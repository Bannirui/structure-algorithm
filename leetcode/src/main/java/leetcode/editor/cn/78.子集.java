import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution
{

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        boolean[] used = new boolean[nums.length];
        this.dfs(nums, 0, new ArrayList<>());
        return this.res;
    }

    private void dfs(int[] nums, int idx, List<Integer> path)
    {
        // base case
        if (idx == nums.length)
        {
            // 收集结果
            this.res.add(new ArrayList<>(path));
            return;
        }
        // 遍历到nums中的idx
        // 使用当前的数字
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(nums[idx]);
        this.dfs(nums, idx + 1, newPath);
        // 不使用当前的数字
        this.dfs(nums, idx + 1, path);
    }
}
// @lc code=end
