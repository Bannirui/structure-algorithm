import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 15:32:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 15:46:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // [a] [b] [c] [d]
        for (int a = 0; a < nums.length; a++) {
            // 避免重复值
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length; b++) {
                // 避免重复值
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // [c]+[d]=target-([a]+[b])
                int c = b + 1, d = nums.length - 1;
                int sum = target - nums[a] - nums[b];
                while (c < d) {
                    int curSum = nums[c] + nums[d];
                    if (curSum == sum) {
                        // 收集
                        List<Integer> path = new ArrayList<>();
                        path.add(nums[a]);
                        path.add(nums[b]);
                        path.add(nums[c]);
                        path.add(nums[d]);
                        res.add(path);
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        c++;
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        d--;
                    }
                    if (curSum < sum) {
                        c++;
                    }
                    if (curSum > sum) {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
