import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-20 13:03:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 16:56:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {

    public int jump(int[] nums) {
        // 贪心 每一步贪下一步能跳跃到最远的决策
        // 上一步贪到的最右位置
        int preEnd = 0;
        // 当前能跳到的最右位置
        int curMostRightPos = 0;
        // 决策下的跳跃次数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能跳跃的最右位置 上一次到达右边界和这次到达右边界之间能够跳的最右位置
            curMostRightPos = Math.max(curMostRightPos, i + nums[i]);
            if (i == preEnd) {
                // 当前来到了上一次的最右位置
                preEnd = curMostRightPos;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end
