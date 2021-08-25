import java.util.Random;

/*
 * @Author: dingRui
 * @Date: 2021-08-25 13:05:37
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-25 15:53:15
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        // 索引
        int res = 0;
        // 数值出现次数统计
        int numCount = 0;
        // 在nums中找target
        for (int i = 0; i < this.nums.length; i++) {
            if (this.nums[i] == target) {
                // 找到了target
                numCount++;
                // 在[0...numCount)出现0的概率=1/numCount
                if (this.random.nextInt(numCount) == 0) {
                    // [0...numCount)
                    res = i;
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end
