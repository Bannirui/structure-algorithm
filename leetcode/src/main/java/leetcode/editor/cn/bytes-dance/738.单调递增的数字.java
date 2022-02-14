/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] numCh = Integer.toString(n).toCharArray();
        int len=numCh.length;
        int i=1;
        while(i<len&&numCh[i-1]<=numCh[i]) i++;
        if(i<len){
            while(i>0 && numCh[i-1]>numCh[i]) {
                numCh[i-1]-=1;
                i-=1;
            }
            for(i+=1;i<len;i++) numCh[i]='9';
        }
        return Integer.parseInt(new String(numCh));
    }
}
// @lc code=end

