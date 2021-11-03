/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 分区
        // [0...pL] 0
        // [pL...pR] 1
        // [pR...] 2
        int pL = -1;
        int pR = nums.length;
        for(int i=0;i<nums.length;i++){
            // 2都换到右边 换过来的可能是1 可能是0 也可能是2 要把cur继续留在当前位置
            while(i<pR && nums[i]==2){
                pR--;
                int tmp=nums[pR];
                nums[pR]=nums[i];
                nums[i]=tmp;
            }
            // 此刻当前位置要么是0 要么是1 继续判断
            if(nums[i]==0){
                pL++;
                int tmp = nums[pL];
                nums[pL]=nums[i];
                nums[i]=tmp;
            }else if(nums[i]==1){
                // todo
                continue;
            }
        }
    }
}
// @lc code=end

