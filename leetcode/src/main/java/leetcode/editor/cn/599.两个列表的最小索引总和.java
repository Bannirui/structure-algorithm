import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-06-21 16:47:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 17:03:07
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 第一个数组元素全部放到hash表 遍历第二个数组
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            String key = list1[i];
            // 如果元素重复 只要脚标最小的那个
            if (!indexMap.containsKey(key)) {
                indexMap.put(key, i);
            }
        }
        List<String> res = new ArrayList<>();
        // 记录历史脚标最小值
        int lastIndexSum = Integer.MAX_VALUE;
        // 遍历第二个数组 判断是否有共同喜好
        for (int j = 0; j < list2.length; j++) {
            if (indexMap.containsKey(list2[j])) {
                // 当前脚标之和
                int curIndexSum = indexMap.get(list2[j]) + j;
                if (curIndexSum == lastIndexSum) {
                    // 多个共同喜好
                    res.add(list2[j]);
                }
                if (curIndexSum < lastIndexSum) {
                    // 出现了脚标之和更小的方案
                    res.clear();
                    lastIndexSum = curIndexSum;
                    res.add(list2[j]);
                }
            }
        }
        // res
        String[] resArr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
// @lc code=end
