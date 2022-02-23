/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len=0;
        if(digits==null || (len=digits.length)==0) throw new IllegalArgumentException();
        for(int i=len-1;i>=0;i--){
            if(digits[i]==9) continue;
            digits[i]++;
            // [0...i) i (i...]
            for(int j=i+1;j<len;j++) digits[j]=0;
            return digits;
        }
        // all the item equals 9
        int[] ret = new int[len+1]; // all item equals 0
        ret[0]=1;
        return ret;
    }
}
// @lc code=end

