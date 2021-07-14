import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-14 23:00:44
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 23:11:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    // 待选择对象
    private int[] nums;

    // 结果集
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return this.res;
        }
        this.nums = this.copyArr(nums);
        List<Integer> path = new ArrayList<>();
        dfs(0, path);
        return this.res;
    }

    // 数组复制
    private int[] copyArr(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    // 决策nums中脚标index的元素
    private void dfs(int index, List<Integer> path) {
        // base case
        if (index == this.nums.length) {
            // 收集结果
            this.res.add(new ArrayList<>(path));
            return;
        }
        // 不选择当前元素
        dfs(index + 1, path);
        // 选择当前元素 规避现场恢复
        List<Integer> copyPath = new ArrayList<>(path);
        copyPath.add(this.nums[index]);
        dfs(index + 1, copyPath);

    }
}
// @lc code=end
