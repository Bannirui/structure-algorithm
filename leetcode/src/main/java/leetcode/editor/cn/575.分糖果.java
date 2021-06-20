import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-06-20 10:43:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-20 10:45:18
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int len = candyType.length;
        for (int i = 0; i < len; i++) {
            set.add(candyType[i]);
        }
        return Math.min(len / 2, set.size());
    }
}
// @lc code=end
