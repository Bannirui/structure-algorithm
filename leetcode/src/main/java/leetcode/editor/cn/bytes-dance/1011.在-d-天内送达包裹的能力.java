/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int len=0;
        if(weights==null || (len=weights.length)==0 || days<=0) throw new IllegalArgumentException();
        int MAX=Integer.MIN_VALUE;
        int SUM=0;
        for(int weight: weights) {
            MAX = Math.max(MAX, weight);
            SUM += weight;
        }
        int L = MAX;
        int R = SUM;
        while(L < R){
            int mid = L + ((R-L)>>1);
            int needDays=1;
            int total=0;
            for(int weight: weights){
                if(total+weight>mid){
                    needDays++;
                    total=0;
                }
                total+=weight;
            }
            if(needDays <= days) R=mid;
            else L=mid+1;

        }
        return L;
    }
}
// @lc code=end

