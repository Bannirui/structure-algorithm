import java.util.LinkedList;
import java.util.Queue;

/*
 * @Author: dingrui
 * @Date: 2021-06-29 14:53:29
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 14:58:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while (this.queue.peek() < (t - 3000)) {
            this.queue.poll();
        }
        return this.queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end
