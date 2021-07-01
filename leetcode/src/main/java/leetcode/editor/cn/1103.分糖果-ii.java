/*
 * @Author: dingrui
 * @Date: 2021-07-01 14:12:10
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 14:59:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int index = 0;
        while (candies != 0) {
            int num = Math.min(index + 1, candies);
            res[index % num_people] += num;
            candies -= num;
            index++;
        }
        return res;
    }
}
// @lc code=end
