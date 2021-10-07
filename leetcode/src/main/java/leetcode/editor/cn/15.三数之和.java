import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // base case
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 相当于在[first...len-1]求两数之和
            int sum = 0 - nums[first];
            int third = len - 1;
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > sum) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> resTmp = new ArrayList<>();
                    resTmp.add(nums[first]);
                    resTmp.add(nums[second]);
                    resTmp.add(nums[third]);
                    res.add(resTmp);
                }
            }
        }
        return res;
    }
}
// @lc code=end
