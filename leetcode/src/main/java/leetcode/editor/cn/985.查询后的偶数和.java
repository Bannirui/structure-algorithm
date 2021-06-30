/*
 * @Author: dingrui
 * @Date: 2021-06-30 09:43:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 10:07:36
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        // 初始偶数之和
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            // 第i次请求
            int val = queries[i][0];
            int index = queries[i][1];
            int oldVal = nums[index];
            if (oldVal % 2 == 0) {
                // 原来是偶数
                if (val % 2 == 0) {
                    // 新增是偶数
                    sum += val;
                } else {
                    // 新增是奇数
                    sum -= oldVal;
                }
            } else {
                // 原来是奇数
                if (val % 2 == 0) {
                    // 新增是偶数
                } else {
                    // 新增是奇数
                    sum += (oldVal + val);
                }
            }
            nums[index] += val;
            res[i] = sum;
        }
        return res;
    }
}
// @lc code=end
