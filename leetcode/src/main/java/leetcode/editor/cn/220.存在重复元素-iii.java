import java.util.Set;
import java.util.TreeSet;

/*
 * @Author: dingrui
 * @Date: 2021-07-29 23:53:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-30 10:46:33
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 滑动窗口
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 是否存在一个数[num-t, num+t]
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                // 找到了
                return true;
            }
            // 在当前窗口内没有找到 继续滑动
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
// @lc code=end
