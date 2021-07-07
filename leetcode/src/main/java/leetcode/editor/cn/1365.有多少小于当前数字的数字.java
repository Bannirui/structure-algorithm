/*
 * @Author: dingrui
 * @Date: 2021-07-07 09:48:08
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 13:39:33
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] help = new int[101];
        // 0...100 出现的次数
        for (int num : nums) {
            help[num]++;
        }
        // 0...100 help[i]表示<=i的次数
        for (int i = 1; i <= 100; i++) {
            help[i] += help[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            if (num == 0) {
                count = 0;
            } else {
                count = help[num - 1];
            }
            res[i] = count;
        }
        return res;
    }
}
// @lc code=end
