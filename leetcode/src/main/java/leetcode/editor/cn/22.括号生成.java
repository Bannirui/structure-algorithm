import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicSplitPaneUI.BasicVerticalLayoutManager;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 15:47:53
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 16:25:33
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // 生成n对括号 n个左括号 n个右括号
        this.backTrace(n, n, "");
        return this.res;
    }

    // 还有left个左括号
    // right个右括号
    // 当前策略下的结果path
    private void backTrace(int left, int right, String path) {
        // base case
        if (left == 0 && right == 0) {
            // 收集结果
            this.res.add(path);
            return;
        }
        // 左括号或者右括号还有剩余没用完
        if (left == right) {
            // 只能先消费左括号
            backTrace(left - 1, right, path + "(");
        } else {
            // 一定成立的条件:left<=right 随便用左括号还是右括号
            if (left > 0) {
                backTrace(left - 1, right, path + "(");
            }
            // 只能使用右括号
            backTrace(left, right - 1, path + ")");
        }
    }
}
// @lc code=end
