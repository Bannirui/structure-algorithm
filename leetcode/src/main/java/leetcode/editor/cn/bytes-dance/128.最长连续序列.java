/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int len=0; // the length of arr
        if(nums==null || (len=nums.length)==0) return 0;
        // get the length during iterator since at the begin of the element
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int ret = 0;
        for(int num: set){ // ...i
            int curNum = num;
            int curLen=1;
            if(!set.contains(curNum-1)){
                // [curNum...]
                while(set.contains(curNum+1)){
                    curLen++;
                    curNum+=1;
                }
            }
            ret = Math.max(ret, curLen);
        }
        return ret;
    }
}
// @lc code=end

