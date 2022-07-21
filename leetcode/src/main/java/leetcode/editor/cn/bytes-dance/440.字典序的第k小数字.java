/*
 * @lc app=leetcode.cn id=440 lang=java
 *
 * [440] 字典序的第K小数字
 */

// @lc code=start
class Solution {
    public int findKthNumber(int n, int k) {
        int cur=1;
        k--;
        while(k>0){
            int cnt=this.cntNodes(cur, n);
            if(k>=cnt){ // ->right
                k-=cnt;
                cur++;
            }else{ // ->down
                k--;
                cur*=10;
            }
        }
        return cur;
    }

    // 以prefix为前缀的树[...n]有多少个节点
    private int cntNodes(int prefix, int n){
        if(prefix>n) return 0;
        int ret=0;
        long cur=prefix;
        long next=prefix+1;
        while(cur<=n){
            ret+=(int)Math.min(next-cur, n-cur+1);
            cur*=10;
            next*=10;
        }
        return ret;
    }
}
// @lc code=end

