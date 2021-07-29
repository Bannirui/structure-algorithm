/*
 * @Author: dingrui
 * @Date: 2021-07-26 07:21:27
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 23:37:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        // 模拟二叉树建立 槽位数量
        int slots = 1;
        for (int i = 0; i < preorder.length();) {
            if (slots == 0) {
                return false;
            }
            char cur = preorder.charAt(i);
            if (cur == ',') {
                // 分隔符
                i++;
            } else if (cur == '#') {
                // 二叉树中的null节点 消耗一个槽位
                slots--;
                i++;
            } else {
                // 数字
                while (i < preorder.length() && preorder.charAt(i) != ',') {
                    i++;
                }
                // 消耗1个槽位 新增2个槽位
                slots += (-1 + 2);
            }
        }
        return slots == 0;
    }
}
// @lc code=end
