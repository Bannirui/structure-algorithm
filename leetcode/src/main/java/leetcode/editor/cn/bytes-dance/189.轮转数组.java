/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int len = 0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err: param");
        if((k%=len)==0) return;
        // [...]
        this.reverse(nums, 0, len-1);
        // [0...k-1]
        this.reverse(nums, 0, k-1);
        // [k...]
        this.reverse(nums, k, len-1);
    }

    // [start...end]
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int tmp = nums[start];
            nums[start++]=nums[end];
            nums[end--]=tmp;
        }
    }
}
// @lc code=end

