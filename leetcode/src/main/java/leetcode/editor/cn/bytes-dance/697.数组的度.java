/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        // 频数 起始坐标 结束坐标
        Map<Integer, int[]> m = new HashMap<>();
        for(int i=0;i<len;i++){
            int curNum=nums[i];
            if(!m.containsKey(curNum)) m.put(curNum, new int[]{1,i,i});
            else{
                m.get(curNum)[0]++;
                m.get(curNum)[2]=i;
            }
        }
        int maxCnt=0;
        int minLen=0;
        for(Map.Entry<Integer, int[]> e: m.entrySet()){
            int[] arr = e.getValue();
            int curCnt=arr[0];
            int curLen=arr[2]-arr[1]+1;
            if(maxCnt>curCnt) continue;
            if(maxCnt==curCnt) minLen=Math.min(minLen, curLen);
            else {
                maxCnt=curCnt;
                minLen=curLen;
            }
        }
        return minLen;
    }
}
// @lc code=end

