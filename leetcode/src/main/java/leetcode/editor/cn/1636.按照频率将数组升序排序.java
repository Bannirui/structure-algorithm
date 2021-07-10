import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 16:03:15
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 16:19:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start
class Solution {
    class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int[] frequencySort(int[] nums) {
        // key=val value=count
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Node> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], countMap.get(nums[i]));
            numList.add(node);
        }
        // sort
        Collections.sort(numList, (o1, o2) -> {
            // 频次升序
            // 值降序
            return (o1.count != o2.count) ? o1.count - o2.count : o2.val - o1.val;
        });
        // res
        int[] res = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            res[i] = numList.get(i).val;
        }
        return res;
    }
}
// @lc code=end
