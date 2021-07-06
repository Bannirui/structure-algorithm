import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-07-06 18:56:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 22:47:50
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1337 lang=java
 *
 * [1337] 矩阵中战斗力最弱的 K 行
 */

// @lc code=start
class Solution {

    class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        // 小根堆 升序
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.count < o2.count) {
                return -1;
            } else if (o1.count == o2.count) {
                if (o1.index < o2.index) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 1;
        });
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                } else {
                    count++;
                }
            }
            Node node = new Node(i, count);
            q.add(node);
        }
        List<Integer> help = new ArrayList<>();
        while (k != 0 && !q.isEmpty()) {
            help.add(q.poll().index);
            k--;
        }
        int[] res = new int[help.size()];
        for (int i = 0; i < help.size(); i++) {
            res[i] = help.get(i);
        }
        return res;
    }
}
// @lc code=end
