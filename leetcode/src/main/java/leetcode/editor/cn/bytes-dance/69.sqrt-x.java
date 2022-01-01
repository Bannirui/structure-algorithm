/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // bs
        int l=0, r=x, ret=-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if((long)mid*mid<=x){ // overflow
                ret=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ret;
    }
}
// @lc code=end

