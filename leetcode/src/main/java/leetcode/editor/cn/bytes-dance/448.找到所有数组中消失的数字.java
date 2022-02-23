/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        for(int i=0;i<len;i++) {
            int newIdx = (nums[i]-1)%len;
            nums[newIdx]+=len;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<len;i++) {
            if(nums[i]<=len) ret.add(i+1);
        }
        return ret;
    }
}
// @lc code=end

