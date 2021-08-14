
/*
 * @Author: dingRui
 * @Date: 2021-08-10 18:24:08
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-14 17:39:38
 * @Description: 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的K对数字
 */

// @lc code=start
class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return Collections.emptyList();
        }
        // 小根堆 放元组下标
        Queue<int[]> smallQueue = new PriorityQueue<>((o1, o2) -> {
            return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
        });
        // 两个数组升序 最小的和肯定是两个数组下标为0的元组
        for (int i = 0; i < nums1.length; i++) {
            smallQueue.offer(new int[] { i, 0 });
        }
        // 收集结果
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 0; j < k && !smallQueue.isEmpty(); j++) {
            // 队列中和最小的下标元组
            int[] tuple = smallQueue.poll();
            res.add(Arrays.asList(nums1[tuple[0]], nums2[tuple[1]]));
            if (tuple[1] + 1 < nums2.length) {
                smallQueue.offer(new int[] { tuple[0], tuple[1] + 1 });
            }
        }
        return res;
    }
}
// @lc code=end
