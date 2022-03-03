/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        this.back(nums, 0, target, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void back(int[] nums, int idx, int target, int sum, List<Integer> path, List<List<Integer>> ret){
        if(path==null || nums==null) throw new IllegalArgumentException();
        if(path.size()==4){
            if(sum==target) ret.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            // [i...] nums中包含i还剩余元素数量
            if((nums.length-1)-i+1 < 4-path.size()) return;
            // [i-1...i]重复
            if(i!=idx && nums[i-1]==nums[i]) continue;
            if(i<nums.length-1 && sum+nums[i]+(3-path.size())*nums[i+1] > target) return;
            if(i<nums.length-1 && sum+nums[i]+(3-path.size())*nums[nums.length-1] < target) continue;
            int newSum=sum+nums[i];
            List<Integer> pathCpy = new ArrayList<>(path);
            pathCpy.add(nums[i]);
            this.back(nums,i+1,target,newSum,pathCpy,ret);
        }
    }
}
// @lc code=end

