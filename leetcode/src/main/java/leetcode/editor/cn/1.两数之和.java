/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // num 脚标
        Map<Integer,Integer> valIdxMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int anotherNum = target-nums[i];
            if(valIdxMap.containsKey(anotherNum)){
                // 找到了两个加数
                return new int[]{i, valIdxMap.get(anotherNum)};
            }else{
                // 目前不存在两个加数满足和为target
                valIdxMap.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
// @lc code=end

