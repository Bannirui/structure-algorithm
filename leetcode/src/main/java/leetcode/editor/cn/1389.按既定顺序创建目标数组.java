import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-07 15:10:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 15:17:58
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1389 lang=java
 *
 * [1389] 按既定顺序创建目标数组
 */

// @lc code=start
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> help = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            help.add(index[i], nums[i]);
        }
        int[] res = new int[help.size()];
        for (int i = 0; i < help.size(); i++) {
            res[i] = help.get(i);
        }
        return res;
    }
}
// @lc code=end
