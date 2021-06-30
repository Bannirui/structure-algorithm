import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 15:19:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 15:41:28
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        // endIndex右滑过程中形成的数字 32位 nums数组长度超过32就会导致num跟着溢出
        // 除5的余数
        int left = 0;
        for (int endIndex = 0; endIndex < nums.length; endIndex++) {
            left = ((left << 1) + nums[endIndex]) % 5;
            if (left == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
// @lc code=end
