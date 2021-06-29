import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-29 15:59:34
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 16:41:40
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 回溯
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        // 缓存数组中对应脚标是否被使用过 false=未使用 true=使用过
        boolean[] usedCache = new boolean[nums.length];
        dfs(nums, 0, path, res, usedCache);
        return res;
    }

    /**
     * len 要填满len长度
     * curLen 当前填到的长度
     * path 形成的中间结果
     * res 存放最终结果
     * cache 缓存已经使用过的
     */
    private void dfs(int[] nums, int curLen, List<Integer> path, List<List<Integer>> res, boolean[] usedCache) {
        // base case
        if (curLen == nums.length) {
            // 收集到一条路径
            res.add(new ArrayList<>(path));
            return;
        }
        // 从没被使用过的数字里面挑一个
        for (int i = 0; i < nums.length; i++) {
            if (!usedCache[i]) {
                // 更新缓存
                usedCache[i] = true;
                List<Integer> tmpPath = new ArrayList<>(path);
                // 当前决策选定的值
                tmpPath.add(nums[i]);
                dfs(nums, curLen + 1, tmpPath, res, usedCache);
                // 现场恢复
                usedCache[i] = false;
            }
        }
    }
}
// @lc code=end
