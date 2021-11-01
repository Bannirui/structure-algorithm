/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        // 穿插
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        int len = nums.length;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copyNums[--len];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copyNums[--len];
        }
    }
}
// @lc code=end
