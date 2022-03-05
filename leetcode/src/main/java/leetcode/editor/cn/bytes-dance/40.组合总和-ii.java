/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        this.backtrack(candidates, 0, target, new ArrayList<>(), ret);
        return ret;
    }

    private void backtrack(int[] nums, int idx, int remain, List<Integer> path, List<List<Integer>> ret){
        // base case
        if(remain==0){
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        if(idx==nums.length) return;
        for(int i=idx;i<nums.length;i++){
            if(remain-nums[i]<0) break;
            if(i>idx && nums[i-1]==nums[i]) continue;
            List<Integer> pathCpy = new ArrayList<>(path);
            pathCpy.add(nums[i]);
            this.backtrack(nums, i+1, remain-nums[i], pathCpy, ret);
        }
    }
}
// @lc code=end

