import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-06 16:34:05
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 16:59:14
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1313 lang=java
 *
 * [1313] 解压缩编码列表
 */

// @lc code=start
class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> helpList = new ArrayList<>();
        for (int i = 0, j = 1; i < nums.length && j < nums.length; i += 2, j += 2) {
            int freq = nums[i];
            int val = nums[j];
            for (int l = 1; l <= freq; l++) {
                helpList.add(val);
            }
        }
        int len = helpList.size();
        int[] res = new int[len];
        for (int k = 0; k < len; k++) {
            res[k] = helpList.get(k);
        }
        return res;
    }
}
// @lc code=end
