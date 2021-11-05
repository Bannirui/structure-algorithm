/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // idx+1=value 两次遍历 第一次按照对应关系调整顺序 第二次遍历找出关系不对应的
        for(int i=0;i<nums.length;i++){
            if(i+1==nums[i]){
                // 已经对应 todo
                continue;
            }else{
                // 当前的idx和value不对应 把value换到正确的脚标上 换过来的这个继续判定
                // 当前脚标i
                // 当前值nums[i]
                // 目标对应的正确脚标nums[i]-1
                while(i!=nums[i]-1&&nums[nums[i]-1]!=nums[i]-1+1){
                    int targetIdx = nums[i]-1;
                    int tmpVal = nums[i];
                    nums[i]=nums[targetIdx];
                    nums[targetIdx]=tmpVal;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
}
// @lc code=end

