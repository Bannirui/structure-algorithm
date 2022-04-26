/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) throw new IllegalArgumentException();
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        this.backtrace(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void backtrace(int[] nums, int idx, List<Integer> tmp, List<List<Integer>> ret){
        // base case
        if(idx==nums.length){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(idx!=0 && nums[idx]==nums[idx-1]) {
            this.backtrace(nums, idx+1, tmp, ret);
            return;
        }
        this.backtrace(nums, idx+1, tmp, ret);
        List<Integer> tmpCpy = new ArrayList<Integer>(tmp);
        tmpCpy.add(nums[idx]);
        this.backtrace(nums, idx+1, tmpCpy, ret);
    }
}
// @lc code=end

