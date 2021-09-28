import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        // 到一个点距离相同的节点数量知道了就可以求出回旋镖的数量
        int res = 0;
        for (int[] curPoint : points) {
            // 其他点跟当前点的距离 所有点互不相同保证了距离是0的点只有1个
            Map<Integer, Integer> disCnt = new HashMap<Integer, Integer>();
            for (int[] otherPoint : points) {
                int dis = (otherPoint[0] - curPoint[0]) * (otherPoint[0] - curPoint[0])
                        + (otherPoint[1] - curPoint[1]) * (otherPoint[1] - curPoint[1]);
                disCnt.put(dis, disCnt.getOrDefault(dis, 0) + 1);
            }
            // 当前节点的回旋镖数量
            for (Map.Entry<Integer, Integer> entry : disCnt.entrySet()) {
                int cnt = entry.getValue();
                res += cnt * (cnt - 1);
            }
        }
        return res;
    }
}
// @lc code=end
