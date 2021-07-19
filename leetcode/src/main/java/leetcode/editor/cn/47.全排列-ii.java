import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-19 22:18:24
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 22:29:53
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {

    // 结果集
    private Set<List<Integer>> res = new HashSet<>();

    // 标志位 脚标
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        this.used = new boolean[nums.length];
        this.dfs(nums, new ArrayList<>());
        return new ArrayList<>(this.res);
    }

    private void dfs(int[] nums, List<Integer> path) {
        // base case
        if (path.size() == nums.length) {
            // 收集
            this.res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!this.used[i]) {
                List<Integer> copyPath = new ArrayList<>(path);
                copyPath.add(nums[i]);
                this.used[i] = true;
                dfs(nums, copyPath);
                // 现场恢复
                this.used[i] = false;
            }
        }
    }
}
// @lc code=end
