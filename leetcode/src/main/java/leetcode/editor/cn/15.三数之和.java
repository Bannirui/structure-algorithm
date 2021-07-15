import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 14:27:23
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 15:07:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 升序 依次在右边找
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            // 当前值没有被枚举过
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // [a]已经确定 找[b]+[c]=0-[a]
            int c = nums.length - 1;
            int sum = 0 - nums[a];
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // b<c
                while (b < c && nums[b] + nums[c] > sum) {
                    c--;
                }
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == sum) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[a]);
                    path.add(nums[b]);
                    path.add(nums[c]);
                    res.add(path);
                }
            }
        }
        return res;
    }
}
// @lc code=end
