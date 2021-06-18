import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-18 13:24:17
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-18 17:42:33
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        // 数组中元素有序 只要连续就连起来 不连续就自己单独成区间
        // 双指针
        List<String> res = new ArrayList<>();
        int len = nums.length;
        // base case
        if (len == 0) {
            return res;
        }
        int slow = 0, fast = 0;
        while (fast + 1 < len) {
            if ((nums[fast] + 1) == nums[fast + 1]) {
                // fast指针探测后一位跟现在是否连续 连续就后移
                fast++;
            } else {
                // 不连续 将当前这一段加入结果集 重置慢指针
                res.add((slow == fast) ? ("" + nums[slow]) : (nums[slow] + "->" + nums[fast]));
                slow = fast + 1;
                fast = fast + 1;
            }
        }
        // fast已经移动到数组最后
        res.add((slow == fast) ? ("" + nums[slow]) : (nums[slow] + "->" + nums[fast]));
        return res;
    }
}
// @lc code=end
