/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err: param");
        if(len==1) return;
        int L=-1, R=len;
        for(int i=0; i<R; i++){
            while(i<R && nums[i]==2){ // 2
                int tmp = nums[i];
                nums[i] = nums[--R];
                nums[R] = tmp;
            }
            // 0 or 1
            if(nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[++L];
                nums[L] = tmp;
            }
        }
    }
}
// @lc code=end

