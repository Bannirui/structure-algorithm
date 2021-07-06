import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-06 17:19:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 17:32:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 辅助数组 升序
        int[] help = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            help[i] = arr[i];
        }
        Arrays.sort(help);
        // map key=值 value=脚标
        Map<Integer, Integer> map = new HashMap<>();
        int lastIndex = 0;
        for (int i = 0; i < help.length; i++) {
            if (!map.containsKey(help[i])) {
                map.put(help[i], ++lastIndex);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            help[i] = map.get(arr[i]);
        }
        return help;
    }
}
// @lc code=end
