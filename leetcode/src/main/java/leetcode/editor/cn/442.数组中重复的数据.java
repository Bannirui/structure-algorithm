/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // idx+1=val
        List<Integer> res = new ArrayList<>();
        // 遍历
        for(int i=0;i<nums.length;i++){
            if(i+1==nums[i]){
                // continue
                continue;
            }else{
                // 交换
                while(i+1!=nums[i] && nums[nums[i]-1]!=nums[i]-1+1){
                    int tmp = nums[i];
                    int targetIdx = nums[i]-1;
                    nums[i] = nums[targetIdx];
                    nums[targetIdx]=tmp;
                }
                // idx已经对应或者当前idx不对应但是目标的已经对应
            }
        }
        // 找出idx跟val不对应的
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]){
                res.add(nums[i]);
            }
        }
        return res;
    }
}
// @lc code=end

