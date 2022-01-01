/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int len=0;
        if(intervals==null || (len=intervals.length)==0) return null; // corner condition
        Arrays.sort(intervals, (a1, a2)->{
            if(a1[0]!=a2[0]){
                return a1[0]-a2[0];
            }else{
                return a1[1]-a2[1];
            }
        });
        Deque<int[]> s = new LinkedList<>();
        for(int i=0; i<len; i++){
            if(!s.isEmpty()){
                if(intervals[i][0]>s.peekLast()[1] || intervals[i][1]<s.peekLast()[0]){
                    // not merge
                    s.offerLast(intervals[i]);
                }else{
                    // merge
                    int[] pre = s.pollLast();
                    s.offerLast(new int[]{Math.min(pre[0], intervals[i][0]), Math.max(pre[1], intervals[i][1])});
                }
            }else{
                // not merge
                s.offerLast(intervals[i]);
            }
        }
        int size=s.size(); // arr cnt
        int[][] ret = new int[size][2];
        for(int i=0;i<size;i++){
            ret[i] = s.pollFirst();
        }
        return ret;
    }
}
// @lc code=end

