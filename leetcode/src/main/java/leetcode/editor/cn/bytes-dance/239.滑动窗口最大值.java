/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=0;
        if(nums==null || (len=nums.length)==0 || k<=0) throw new IllegalArgumentException();
        // base
        if(k==1) return nums;
        int[] ret=new int[len-k+1];
        // int[2] val idx
        Queue<int[]> q = new PriorityQueue<>((o1, o2)->{
            int v1=o1[0];
            int idx1=o1[1];
            int v2=o2[0];
            int idx2=o2[1];
            if(v1!=v2) return v2-v1;
            else return idx2-idx1;
        });
        // [0...k-1]
        for(int i=0;i<k;i++) q.offer(new int[]{nums[i], i});
        ret[0]=q.peek()[0];
        // [k...] the end of window
        for(int i=k;i<len;i++){
            // [i-k+1...i]
            q.offer(new int[]{nums[i], i});
            while(q.peek()[1]<i-k+1) q.poll();
            ret[i-k+1]=q.peek()[0];
        }
        return ret;
    }
}
// @lc code=end

