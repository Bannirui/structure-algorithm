/*
 * @Author: dingRui
 * @Date: 2021-08-03 17:09:21
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 17:35:26
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // 环形链表入环变形
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        // 首次相遇 fast指针一次两个节点 slow指针一次一个节点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // fast指针回到起点 一次一个节点
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end
