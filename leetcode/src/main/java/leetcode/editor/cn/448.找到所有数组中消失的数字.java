/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // [1...n]对应脚标[0...n-1] 最后再遍历一边找出不对应的
        for(int i=0;i<nums.length;i++){
            // 当前值nums[i] 对应脚标nums[i]-1
            if(i+1==nums[i]){
                // 值与脚标对应
                continue;
            }else{
                // 值与脚标不对应
                // 把当前值换到正确的脚标上 换过来的不一定正确对应
                while(i+1!=nums[i]&&nums[i]!=nums[nums[i]-1]){
                    int destIdx = nums[i]-1;
                    int tmp=nums[i];
                    nums[i]=nums[destIdx];
                    nums[destIdx]=tmp;
                }
            }
        }
        // 能对应的已经全部对应结束了
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]){
                res.add(i+1);
            }
        }
        return res;
    }
}
// @lc code=end

