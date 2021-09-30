/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int len = 0;
        // base case
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        // 数字为正
        boolean positive = true;
        // 在此之前已经读入过数字标识
        boolean visitNum = false;
        // 在此之前已经读入过正负号
        boolean visitPos = false;
        int curNum = 0;
        for (int i = 0; i < len; i++) {
            // 如果已经读入了数字 后面再遇到非数字的直接终止
            char curChar = s.charAt(i);
            boolean curIsNum = Character.isDigit(curChar);
            if (visitNum && !curIsNum) {
                break;
            }
            // 准备读入字符
            if (curIsNum) {
                visitNum = true;
                // 溢出检查
                if (curNum < Integer.MIN_VALUE / 10
                        || (curNum == Integer.MIN_VALUE / 10 && (curChar - '0') > -(Integer.MIN_VALUE % 10))) {
                    curNum = Integer.MIN_VALUE;
                    break;
                }
                if (curNum > Integer.MAX_VALUE / 10
                        || (curNum == Integer.MAX_VALUE / 10 && (curChar - '0' > Integer.MAX_VALUE % 10))) {
                    curNum = Integer.MAX_VALUE;
                    break;
                }
                curNum = positive ? (curNum * 10 + (curChar - '0')) : (curNum * 10 - (curChar - '0'));
            } else {
                // 当前字符不是数字
                if (visitNum || visitPos) {
                    // 已经生成了数字 终止条件
                    break;
                } else {
                    // 还没有数字生成 当前字符非数字
                    if (curChar == '-') {
                        if (visitPos) {
                            break;
                        } else {
                            positive = false;
                            visitPos = true;
                        }
                    } else if (curChar == '+') {
                        if (visitPos) {
                            break;
                        } else {
                            positive = true;
                            visitPos = true;
                        }
                    } else if (curChar == ' ') {
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
        return curNum;
    }
}
// @lc code=end
