import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-01 15:05:02
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 16:02:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // value-index
        Map<Integer, Integer> helpMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            helpMap.put(arr2[i], i);
        }
        // arr1元素放到helpList中使用排序工具类
        List<Integer> helpList = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            helpList.add(arr1[i]);
        }
        Collections.sort(helpList, (o1, o2) -> {
            if (helpMap.containsKey(o1)) {
                if (helpMap.containsKey(o2)) {
                    return helpMap.get(o1) - helpMap.get(o2);
                } else {
                    return -1;
                }
            } else {
                if (helpMap.containsKey(o2)) {
                    return 1;
                } else {
                    return o1 - o2;
                }
            }
        });
        int[] res = new int[helpList.size()];
        for (int i = 0; i < helpList.size(); i++) {
            res[i] = helpList.get(i);
        }
        return res;
    }
}
// @lc code=end
