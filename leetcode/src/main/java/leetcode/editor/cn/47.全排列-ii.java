/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {

    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        this.trace(nums, used, new ArrayList<>());
        return new ArrayList<>(this.res);
    }

    // 不重复
    private void trace(int[] nums, boolean[] used, List<Integer> path){
        // base case
        if(path.size()==nums.length){
            this.res.add(new ArrayList<Integer>(path));
            return;
        }
        // 从nums中找没有被使用过的数字
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                boolean[] newUsed = used.clone();
                newUsed[i]=true;
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                this.trace(nums, newUsed, newPath);
            }
        }
    }
}
// @lc code=end

