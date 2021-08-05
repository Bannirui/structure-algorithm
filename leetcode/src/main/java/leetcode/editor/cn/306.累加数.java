/*
 * @Author: dingRui
 * @Date: 2021-08-05 10:43:45
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 11:31:07
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return this.dfs(num, 0, 0, 0, 0);
    }

    /**
     * 
     * @param num 字符串
     * @param index 当前处理的脚标
     * @param preTwoSum 前面两个数字的和
     * @param preNum 前面的数字
     * @param count 处理到第几个数字
     * @return
     */
    private boolean dfs(String num, int index, long preTwoSum, long preNum, int count) {
        // base case
        if (index == num.length()) {
            // 找到最后了 看看处理了几个数字了
            return count > 2;
        }
        // 当前来到了index脚标 前面两个数字已经定了 在[index...]找第3个数字
        for (int i = index; i < num.length(); i++) {
            // [index...i]形成第3个数字
            long curNum = this.generateNum(num, index, i);
            if (curNum == -1) {
                // 前导0情况 继续 让代码进base case
                continue;
            }
            if (count >= 2 && curNum != preTwoSum) {
                // 前面两数之和
                continue;
            }
            // 当前已经处理完了i下标
            if (dfs(num, i + 1, preNum + curNum, curNum, count + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param num 字符串
     * @param start 开始下标
     * @param end 结束下标
     * @return
     */
    private long generateNum(String num, int start, int end) {
        // 没有前导0 但是不排除start==end的时候出现0就是代表0
        if (start < end && num.charAt(start) == '0') {
            return -1L;
        }
        long res = 0;
        while (start <= end) {
            res = res * 10 + num.charAt(start++) - '0';
        }
        return res;
    }

}
// @lc code=end
