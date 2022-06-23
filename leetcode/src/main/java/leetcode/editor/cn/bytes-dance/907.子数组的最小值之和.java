/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
class Solution {

    static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int len=0;
        if(arr==null || (len=arr.length)==0) throw new IllegalArgumentException();
        if(len==1) return arr[0];
        int[] pre = new int[len];
        int[] suf = new int[len];

        Stack<Integer> idxStack4Pre = new Stack<>();
        for(int i=0;i<len;i++){
            while(!idxStack4Pre.isEmpty() && arr[i]<=arr[idxStack4Pre.peek()])
                idxStack4Pre.pop();
            pre[i]=idxStack4Pre.isEmpty()?-1:idxStack4Pre.peek();
            idxStack4Pre.push(i);
        }

        Stack<Integer> idxStack4Suf = new Stack<>();
        for(int i=len-1;i>=0;i--){
            while(!idxStack4Suf.isEmpty() && arr[i]<arr[idxStack4Suf.peek()])
                idxStack4Suf.pop();
            suf[i]=idxStack4Suf.isEmpty()?len:idxStack4Suf.peek();
            idxStack4Suf.push(i);
        }

        long ret=0;
        for(int i=0;i<len;i++){
            int m=i-pre[i];
            int n=suf[i]-i;
            ret+=(long)(m*n%MOD*arr[i]%MOD);
            ret%=MOD;
        }
        return (int)ret;
    }
}
// @lc code=end

