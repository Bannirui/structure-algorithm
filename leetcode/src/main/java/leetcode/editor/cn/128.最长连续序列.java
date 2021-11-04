/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // 元素放到set中
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            set.add(num);
        }
        // 遍历 统计以num结尾的最长连续长度
        int res=0;
        for(int num: nums){
            if(!set.contains(num+1)){
                // 当前数字num 以num结尾的序列长度
            int curNum=num;
            int curLen = 1;
            while(set.contains(curNum-1)){
                curLen++;
                curNum--;
            }
            res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
// @lc code=end

