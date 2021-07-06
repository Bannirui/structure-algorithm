import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-06 22:59:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 23:14:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
class Solution {

    class Node {
        int bitCount;
        int val;

        public Node(int bitCount, int val) {
            this.bitCount = bitCount;
            this.val = val;
        }
    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, Node> map = new HashMap<>(arr.length);
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            } else {
                Node node = new Node(Integer.bitCount(arr[i]), arr[i]);
                list.add(node);
                map.put(arr[i], node);
            }
        }
        // 二进制1的数量升序 数值升序
        Collections.sort(list, (o1, o2) -> {
            if (o1.bitCount < o2.bitCount) {
                return -1;
            }
            if (o1.bitCount == o2.bitCount) {
                return o1.val - o2.val;
            }
            return 1;
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).val;
        }
        return res;
    }
}
// @lc code=end
