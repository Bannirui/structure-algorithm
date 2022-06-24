/*
 * @lc app=leetcode.cn id=1353 lang=java
 *
 * [1353] 最多可以参加的会议数目
 */

// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {
        int len=0;
        if(events==null || (len=events.length)==0) return 0;
        // 会议开始时间升序
        Arrays.sort(events, (e0, e1)->{
            if(e0[0]==e1[0]) return e0[1]-e1[1];
            return e0[0]-e1[0];
        });
        Queue<Integer> q = new PriorityQueue<>();
        int ret=0; // 结果
        int idx=0; // 指针
        int nextDay=0; // 待处理的第几天
        while(idx<len || !q.isEmpty()){
            if(q.isEmpty()){
                q.offer(events[idx][1]);
                nextDay = events[idx++][0];
            }
            // 会议开始事件是nextDay 可以参加的都放到队列里面 集中贪一个结束时间最早的
            while(idx<len && events[idx][0]<=nextDay){
                q.offer(events[idx++][1]);
            }
            if(q.peek()>=nextDay){
                nextDay++;
                ret++;
            }
            q.poll();
        }
        return ret;
    }
}
// @lc code=end

