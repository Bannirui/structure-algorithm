/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len=0;
        if(nums==null || (len=nums.length)==0) return ret;
        Arrays.sort(nums); // asc
        // iterator l+m+r=0
        for(int l=0; l<len; l++){ // l
            if(l!=0 && nums[l]==nums[l-1]){
                continue; // pass the repeat element
            }
            int r=len-1; // r
            int sum = -nums[l]; // m+r
            for(int m=l+1; m<len; m++){
                if(m!=l+1 && nums[m]==nums[m-1]){
                    continue; // pass the repeat element
                }
                while(m<r&&nums[m]+nums[r]>sum){
                    r--;
                }
                if(m==r){
                    break;
                }
                if(nums[m]+nums[r]==sum){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[l]);
                    tmp.add(nums[m]);
                    tmp.add(nums[r]);
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }
}
// @lc code=end

