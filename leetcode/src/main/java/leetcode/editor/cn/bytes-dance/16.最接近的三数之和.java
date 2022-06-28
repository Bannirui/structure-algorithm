/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len=0;
        if(nums==null || (len=nums.length)<3) throw new IllegalArgumentException();
        Arrays.sort(nums);
        int ret=1000000;
        for(int i=0;i<len;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1, k=len-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target) return sum;
                if(Math.abs(sum - target)<Math.abs(ret - target)) ret=sum;
                if(sum>target){
                    int k0=k-1;
                    while(j<k0 && nums[k0]==nums[k]) k0--;
                    k=k0;
                }else{
                    int j0=j+1;
                    while(j0<k && nums[j0]==nums[j]) j0++;
                    j=j0;
                }
            }
        }
        return ret;
    }
}
// @lc code=end

