/*
 * @lc app=leetcode.cn id=1524 lang=java
 *
 * [1524] 和为奇数的子数组数目
 */

// @lc code=start
class Solution {
    
    private static int MAGIC = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int len=0;
        if(arr==null || (len=arr.length)==0) throw new IllegalArgumentException();
        int ret=0;
        int sum=0;
        int odd=0, even=1;
        for(int i=0;i<len;i++){
            sum += arr[i];
            ret = (ret+(sum%2==0?odd:even))%MAGIC;
            if(sum%2==0) even++;
            else odd++;
        }
        return ret;
    }
}
// @lc code=end

