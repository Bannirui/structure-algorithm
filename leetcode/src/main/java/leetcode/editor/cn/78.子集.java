/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    // 结果集
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // trace
        this.trace(nums, 0, new ArrayList<Integer>());
        return this.res;
    }

    private void trace(int[] nums, int idx, List<Integer> path){
        // base case
        if(idx==nums.length){
            this.res.add(new ArrayList<>(path));
            return;
        }
        // 当前来到idx 可以选择使用或者不使用
        List<Integer> newPath = new ArrayList<>(path){{
            add(nums[idx]);
        }};
        this.trace(nums, idx+1, newPath);
        this.trace(nums, idx+1, path);
    }
}
// @lc code=end

