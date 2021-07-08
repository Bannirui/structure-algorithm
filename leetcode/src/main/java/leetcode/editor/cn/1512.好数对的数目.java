/*
 * @Author: dingrui
 * @Date: 2021-07-08 15:14:57
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 15:33:00
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1512 lang=java
 *
 * [1512] 好数对的数目
 */

// @lc code=start
class Solution {
    public int numIdenticalPairs(int[] nums) {
        // 值最少出现两次
        int[] helpArr = new int[101];
        for (int num : nums) {
            helpArr[num]++;
        }
        // 值出现的最多次数
        int res = 0;
        for (int i = 0; i < 101; i++) {
            if (helpArr[i] >= 2) {
                int product = this.product(helpArr[i]);
                res += product;
            }
        }
        return res;
    }

    // 1...num的组合方式
    private int product(int num) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            res += i;
        }
        return res;
    }
}
// @lc code=end
