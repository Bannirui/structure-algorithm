/*
 * @Author: dingRui
 * @Date: 2021-08-02 14:18:43
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-02 14:47:17
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 不要使用除法
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];
        l[0] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        r[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }
}
// @lc code=end
