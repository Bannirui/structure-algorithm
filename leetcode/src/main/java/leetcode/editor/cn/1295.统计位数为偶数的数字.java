/*
 * @Author: dingrui
 * @Date: 2021-07-05 13:14:02
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 13:20:41
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1295 lang=java
 *
 * [1295] 统计位数为偶数的数字
 */

// @lc code=start
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (this.isFindNumber(nums[i])) {
                res++;
            }
        }
        return res;
    }

    private boolean isFindNumber(int num) {
        int counts = 0;
        while (num != 0) {
            counts++;
            num /= 10;
        }
        return counts % 2 == 0;
    }
}
// @lc code=end
