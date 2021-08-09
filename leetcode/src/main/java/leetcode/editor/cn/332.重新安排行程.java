
/*
 * @Author: dingRui
 * @Date: 2021-08-09 15:13:19
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-09 22:06:14
 * @Description: 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {

    private Map<String, Queue<String>> map = new HashMap<>();
    private List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<String>());
            }
            map.get(from).offer(to);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String cur) {
        while (this.map.containsKey(cur) && this.map.get(cur).size() > 0) {
            String tmp = this.map.get(cur).poll();
            this.dfs(tmp);
        }
        this.res.add(cur);
    }
}
// @lc code=end
