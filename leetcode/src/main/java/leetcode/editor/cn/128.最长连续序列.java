/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // [num...]
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int maxLen=0;
        // 遍历
        for(int num: nums){
            int curLen=0;
            if(!set.contains(num-1)){
                // num开头的序列
                curLen++;
                int curNum = num;
                while(set.contains(curNum+1)){
                    curLen++;
                    curNum++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
// @lc code=end

