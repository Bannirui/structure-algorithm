/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132 模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int k=Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for(int i=len-1; i>=0; i--){
            int cur=nums[i];
            if(cur<k) return true;
            while(!s.isEmpty() && cur>s.peek()) k=Math.max(k, s.pop());
            s.push(cur);
        }
        return false;
    }
}
// @lc code=end

