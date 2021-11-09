/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        // 前缀和
        int preSum=0;
        // 前缀和的计数
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        preSumCnt.put(0, 1);
        // 遍历
        for(int i=0;i<nums.length;i++){
            // 前缀和更新
            preSum+=nums[i];
            cnt+=preSumCnt.getOrDefault(preSum-k,0);
            // 更新前缀和计数
            preSumCnt.put(preSum,preSumCnt.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}
// @lc code=end

