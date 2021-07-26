import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 14:34:48
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 14:49:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        // 字典序
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
// @lc code=end
