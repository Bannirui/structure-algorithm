import java.util.Stack;

/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        // base case
        if (nums == null || nums.length == 0) {
            throw new RuntimeException();
        }
        // 单调栈 存放脚标
        Stack<Integer> ascStack4Idx = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (ascStack4Idx.isEmpty() || nums[i] >= nums[ascStack4Idx.peek()]) {
                // 入栈
                ascStack4Idx.push(i);
            } else {
                // 出现递减值
                return ascStack4Idx.pop();
            }
        }
        // 数组是非递减的 峰值就是最后一个元素
        return nums.length - 1;
    }
}
// @lc code=end
