/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    private int size;

    public List<List<Integer>> permute(int[] nums) {
        this.size = nums.length;
        // default value is false
        boolean[] used = new boolean[nums.length];
        this.traceBack(nums, used, new ArrayList<Integer>());
        return this.res;
    }

    private void traceBack(int[] nums, boolean[] used,List<Integer> path){
        // base case
        if(path.size()==this.size){
            // gather
            this.res.add(new ArrayList<>(path));
            return;
        }
        // unused ele
        for(int i=0;i<this.size;i++){
            if(!used[i]){
                boolean[] usedCpy = Arrays.copyOf(used, used.length);
                usedCpy[i]=true;
                List<Integer> pathCpy = new ArrayList<>(path);
                pathCpy.add(nums[i]);
                this.traceBack(nums, usedCpy, pathCpy);
            }
        }
    }
}
// @lc code=end

