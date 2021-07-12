import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 10:29:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 11:01:54
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1700 lang=java
 *
 * [1700] 无法吃午餐的学生数量
 */

// @lc code=start
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // 三明治需求
        int[] need = new int[2];
        for (int student : students) {
            need[student]++;
        }
        // 消费三明治
        for (int i = 0; i < sandwiches.length; i++) {
            // 当前三明治是否被需要
            int curSandwiches = sandwiches[i];
            if (need[curSandwiches] > 0) {
                need[curSandwiches]--;
            } else {
                // 当前没人需要
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}
// @lc code=end
