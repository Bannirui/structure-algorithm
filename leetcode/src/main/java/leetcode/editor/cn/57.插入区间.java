import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-20 23:18:43
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 13:48:27
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 当前已经没有重合 逐个找到与目标重合的进行合并
        int mergedLeft = newInterval[0], mergedRight = newInterval[1];
        // newInterval或者合并之后形成的区间是否应被收集为答案
        boolean collect = false;
        List<int[]> resList = new ArrayList<>();
        for (int[] interval : intervals) {
            int curLeft = interval[0];
            int curRight = interval[1];
            if (curLeft > mergedRight) {
                // 目标在左边
                // 收集目标 并且标识已经被收集过了
                if (!collect) {
                    resList.add(new int[] { mergedLeft, mergedRight });
                    collect = true;
                }
                // 收集当前遍历的对象
                resList.add(interval);
            } else if (curRight < mergedLeft) {
                // 目标在右边
                // 收集当前遍历对象 目标留着下一个遍历对象进行比较
                resList.add(interval);
            } else {
                // 目标跟当前遍历的有重合 需要合并
                mergedLeft = Math.min(mergedLeft, curLeft);
                mergedRight = Math.max(mergedRight, curRight);
            }
        }
        // 遍历完后看一下目标是否已经合并成大区间还没收集
        if (!collect) {
            resList.add(new int[] { mergedLeft, mergedRight });
        }
        // 转数组
        int[][] resArr = new int[resList.size()][2];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }
}
// @lc code=end
