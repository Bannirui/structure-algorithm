/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        Map<Integer,Integer> val2IdxMap = new HashMap<>();
        for(int i=0;i<len;i++){
            if(val2IdxMap.containsKey(nums[i]) && i-val2IdxMap.get(nums[i])<=k) return true;
            val2IdxMap.put(nums[i],i);
        }
        return false;
    }
}
// @lc code=end

