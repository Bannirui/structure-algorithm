/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {

    // key=target
    // value=combines
    private Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        return this.backtrack(nums, target);
    }

    private int backtrack(int[] nums, int remain){
        // base case
        if(remain==0) return 1;
        if(this.map.containsKey(remain)) return this.map.get(remain);
        int ret=0;
        for(int i=0;i<nums.length;i++) 
            if(remain>=nums[i])
                ret+=this.backtrack(nums, remain-nums[i]);
        this.map.put(remain, ret);
        return ret;
    }
}
// @lc code=end

