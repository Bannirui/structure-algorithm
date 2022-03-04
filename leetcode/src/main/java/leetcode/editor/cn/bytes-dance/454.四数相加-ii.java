/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i: nums1){
            for(int j: nums2){
                int sum=i+j;
                cnt.put(sum, cnt.getOrDefault(sum,0)+1);
            }
        }
        int ret=0;
        for(int i: nums3){
            for(int j: nums4){
                int sum=i+j;
                ret+=cnt.getOrDefault(-sum, 0);
            }
        }
        return ret;
    }
}
// @lc code=end

