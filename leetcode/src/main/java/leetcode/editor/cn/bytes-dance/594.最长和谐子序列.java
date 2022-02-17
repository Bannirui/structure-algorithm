/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> cnt = new HashMap<>();
        for(int num: nums){
            cnt.put(num, cnt.getOrDefault(num,0)+1);
        }
        int ret=0;
        for(int num: cnt.keySet()){
            if(cnt.containsKey(num+1)) ret=Math.max(cnt.get(num)+cnt.get(num+1),ret);
        }
        return ret;
    }
}
// @lc code=end

