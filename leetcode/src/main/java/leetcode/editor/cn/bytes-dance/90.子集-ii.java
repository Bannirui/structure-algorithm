/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

    private Set<List<Integer>> ret = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        Arrays.sort(nums);
        this.dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(this.ret);
    }

    private void dfs(int[] nums, int idx, List<Integer> path){
        // param
        if(nums==null || nums.length==0) return;
        // base case
        if(idx==nums.length){
            this.ret.add(new ArrayList<>(path));
            return;
        }
        // select cur item or discard
        int curNum = nums[idx];
        this.dfs(nums, idx+1, path);
        List<Integer> pathCpy = new ArrayList<>(path);
        pathCpy.add(curNum);
        this.dfs(nums, idx+1, pathCpy);
    }
}
// @lc code=end

