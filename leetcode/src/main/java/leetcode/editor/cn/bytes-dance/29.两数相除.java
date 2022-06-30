/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0) throw new IllegalArgumentException();
        if(dividend==0) return 0;
        // 被除数
        if(dividend==Integer.MIN_VALUE){
            if(divisor==1) return Integer.MIN_VALUE;
            if(divisor==-1) return Integer.MAX_VALUE;
        }
        // 除数
        if(divisor==Integer.MIN_VALUE) return dividend==Integer.MIN_VALUE?1:0;
        
        boolean rev = false;
        if(dividend>0){
            dividend=-dividend;
            rev=!rev;
        }
        if(divisor>0){
            divisor=-divisor;
            rev=!rev;
        }

        List<Integer> candidates = new ArrayList<>();
        candidates.add(divisor);
        int index=0;
        while(candidates.get(index)>=dividend-candidates.get(index)){
            candidates.add(candidates.get(index)+candidates.get(index));
            index++;
        }
        int ans=0;
        for(int i=candidates.size()-1;i>=0;i--){
            if(candidates.get(i)>=dividend){
                ans+=(1<<i);
                dividend-=candidates.get(i);
            }
        }
        return rev?-ans:ans;
    }
}
// @lc code=end

