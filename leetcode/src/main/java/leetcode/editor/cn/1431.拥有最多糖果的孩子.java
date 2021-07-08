import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 09:48:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 09:55:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 当前糖果最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        // 阈值limit >=limit的加上额外糖果都可以成为最大值
        int limit = max - extraCandies;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= limit) {
                res.add(Boolean.TRUE);
            } else {
                res.add(Boolean.FALSE);
            }
        }
        return res;
    }
}
// @lc code=end
