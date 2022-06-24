/*
 * @lc app=leetcode.cn id=1498 lang=java
 *
 * [1498] 满足条件的子序列数目
 */

// @lc code=start
class Solution {

    static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return 0;
        Arrays.sort(nums);
        long ret =0;
        for(int i=0;i<len;i++){
            if(nums[i]*2>target) break;
            int l=i;
            int r=len-1;
            while(l<r){
                int mid = (l+r+1)>>1;
                if(nums[i]+nums[mid]>target) r=mid-1;
                else l=mid;
            }
            // l
            if(nums[i]+nums[l]>target) break;
            ret += this.myPow(2, l-i);
            ret%=MOD;
        }
        return (int)ret;
    }

    // x的y次方
    private long myPow(int x, int y){
        long ret = 1;
        int _x = x;
        while(y>0){
            if((y&1)==1) ret=(ret*_x)%MOD;
            _x=(_x*_x)%MOD;
            y>>=1;
        }
        return ret%MOD;
    }
}
// @lc code=end

