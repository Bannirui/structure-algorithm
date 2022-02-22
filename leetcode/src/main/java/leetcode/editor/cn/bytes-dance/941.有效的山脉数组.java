/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        int len=0;
        if(arr==null || (len=arr.length)<3) return false;
        int i=0;
        while(i+1<len && arr[i]<arr[i+1]) i++;
        if(i==0 || i==len-1) return false;
        while(i+1<len && arr[i]>arr[i+1]) i++;
        return i==len-1;
    }
}
// @lc code=end

