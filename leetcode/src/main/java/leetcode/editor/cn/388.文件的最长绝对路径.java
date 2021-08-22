/*
 * @Author: dingRui
 * @Date: 2021-08-18 16:18:41
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-22 15:18:21
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        // \n分隔符
        String[] strArr = input.split("\n");
        int res = 0;
        int[] lenSum = new int[strArr.length + 1];
        for (String str : strArr) {
            // \t分隔符 \t数量 没有\t的lastIndex=-1 表示根路径 在第一层
            int level = str.lastIndexOf("\t") + 2;
            // 实际长度
            int len = str.length() - (level - 1);
            if (str.contains(".")) {
                // 包含. 表示文件
                res = Math.max(res, lenSum[level - 1] + len);
            } else {
                // 表示目录 目录结尾有个\
                lenSum[level] = lenSum[level - 1] + len + 1;
            }
        }
        return res;
    }
}
// @lc code=end
