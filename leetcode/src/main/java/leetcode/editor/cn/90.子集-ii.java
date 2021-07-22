import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 14:21:24
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 14:38:35
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        this.dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(this.res);
    }

    // 在nums这个数组中下标中[index...]选取数字
    // 当前策略之前已经形成的决策是path
    private void dfs(int[] nums, int index, List<Integer> path) {
        // base case
        if (index == nums.length) {
            // 数字选完了 收集答案
            this.res.add(new ArrayList<>(path));
            return;
        }
        // nunms[index]要或者不要
        List<Integer> copyPath = new ArrayList<>(path);
        dfs(nums, index + 1, copyPath);
        copyPath.add(nums[index]);
        dfs(nums, index + 1, copyPath);
    }
}
// @lc code=end
