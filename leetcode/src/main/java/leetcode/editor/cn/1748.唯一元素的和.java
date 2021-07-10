import java.util.HashSet;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 18:52:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 19:04:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1748 lang=java
 *
 * [1748] 唯一元素的和
 */

// @lc code=start
class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cache = new int[101];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            cache[nums[i]]++;
        }
        for (int i = 0; i < 101; i++) {
            if (cache[i] == 1) {
                res += i;
            }
        }
        return res;
    }
}
// @lc code=end
