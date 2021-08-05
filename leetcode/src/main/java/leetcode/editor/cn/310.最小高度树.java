import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Author: dingRui
 * @Date: 2021-08-05 15:08:03
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 21:46:15
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<Integer>() {
                {
                    add(0);
                }
            };
        }
        // 每个顶点的度
        int[] degrees = new int[n];
        // 每个顶点的邻边
        List<List<Integer>> neighbors = new ArrayList<>();
        // 每个顶点的邻边集合
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        // 遍历顶点
        for (int[] edge : edges) {
            int point0 = edge[0], point1 = edge[1];
            // 度
            degrees[point0]++;
            degrees[point1]++;
            // 邻边
            neighbors.get(point0).add(point1);
            neighbors.get(point1).add(point0);
        }
        // 度为1的是叶子节点 从叶子节点往内层扫 最后剩下的就是根节点
        Queue<Integer> q = new LinkedList<>();
        for (int idx = 0; idx < n; idx++) {
            if (degrees[idx] == 1) {
                q.offer(idx);
            }
        }
        // 消费队列中的顶点 减少度 加邻边
        List<Integer> res = null;
        while (!q.isEmpty()) {
            // 一层一个集合收集结果
            res = new ArrayList<Integer>();
            // 当前队列中的元素数量 每一轮只消费当前层的节点
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // 当前节点
                int cur = q.poll();
                res.add(cur);
                // 该顶点的邻边
                for (int neighbor : neighbors.get(cur)) {
                    // 因为自己当前这个节点被删除了 邻边的度就少了自己这一个
                    degrees[neighbor]--;
                    // 如果邻边的度也减少到了1 说明此刻它也成了叶子节点
                    if (degrees[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
