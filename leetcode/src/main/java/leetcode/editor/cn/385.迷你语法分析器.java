/*
 * @Author: dingRui
 * @Date: 2021-08-17 15:48:23
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-18 10:13:11
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {

    // 待处理的字符串
    private String s;
    // 当前处理的字符串下标
    private int curIndex;

    public NestedInteger deserialize(String s) {
        // 参数检查
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        // 递归
        this.s = s;
        this.curIndex = 0;
        return this.dfs();
    }

    private NestedInteger dfs() {
        // [...]处理的数字
        int num = 0;
        // 形成的有效数字正负
        int positive = 1;
        NestedInteger res = new NestedInteger();
        while (this.curIndex != this.s.length()) {
            this.curIndex++;
            // 当前处理的字符: [ 数字 , ] -
            char curChar = s.charAt(this.curIndex);
            if (curChar == ',') {
                // 逗号
                continue;
            } else if (curChar == '[') {
                // 开始新的递归
                res.add(this.dfs());
            } else if (curChar == ']') {
                // 结束当前递归
                return res;
            } else if (curChar == '-') {
                // 负数
                positive = -1;
            } else {
                // 数字
                num = num * 10 + positive * (curChar - '0');
                char nextChar = s.charAt(this.curIndex + 1);
                if (nextChar == ',' || nextChar == ']') {
                    // [...]当前递归内的数字已经收集完毕
                    res.add(new NestedInteger(num));
                    num = 0;
                    positive = 1;
                }
            }
        }
        return res;
    }
}
// @lc code=end
