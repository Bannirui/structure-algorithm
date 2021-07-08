import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 10:29:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 10:44:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1441 lang=java
 *
 * [1441] 用栈操作构建数组
 */

// @lc code=start
class Solution {
    public List<String> buildArray(final int[] target, final int n) {
        List<String> res = new ArrayList<>();
        int curNum = 1;
        for (int i = 0; i < target.length;) {
            if (curNum == target[i]) {
                // 这个数字要放进数组
                res.add("Push");
                curNum++;
                i++;
                continue;
            }
            // 这个数字不需要放入数组
            while (curNum != target[i]) {
                res.add("Push");
                res.add("Pop");
                curNum++;
            }
        }
        return res;
    }
}
// @lc code=end
