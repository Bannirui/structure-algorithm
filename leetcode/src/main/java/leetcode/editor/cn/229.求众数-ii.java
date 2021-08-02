
/*
 * @Author: dingrui
 * @Date: 2021-07-30 17:14:39
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-02 11:16:36
 * @Descripttion: 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        // 超过n/3次的元素 这样的元素至多2个
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;
        // 匹配 计数
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
                continue;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                // 重置候选人
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                // 重置候选人
                candidate2 = num;
                count2++;
            } else {
                // 非候选人
                count1--;
                count2--;
            }
        }
        // 计数 至多有2个众数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
// @lc code=end
