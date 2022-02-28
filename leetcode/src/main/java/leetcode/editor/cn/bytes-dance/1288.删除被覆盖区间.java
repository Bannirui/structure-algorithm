/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals==null) throw new IllegalArgumentException();
        Arrays.sort(intervals, (arr1, arr2)->{
            return arr1[0]==arr2[0]?arr2[1]-arr1[1]:arr1[0]-arr2[0];
        });

        int cnt=0;
        int preEnd=Integer.MIN_VALUE;
        for(int[] interval: intervals){
            if(preEnd<interval[1]){
                cnt++;
                preEnd=interval[1];
            }
        }
        return cnt;
    }
}
// @lc code=end

