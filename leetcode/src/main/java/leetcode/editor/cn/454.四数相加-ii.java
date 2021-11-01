/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumCnt = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                sumCnt.put(sum, sumCnt.getOrDefault(sum, 0) + 1);
            }
        }

        int cnt = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                cnt += sumCnt.getOrDefault(-sum, 0);
            }
        }
        return cnt;
    }
}
// @lc code=end
