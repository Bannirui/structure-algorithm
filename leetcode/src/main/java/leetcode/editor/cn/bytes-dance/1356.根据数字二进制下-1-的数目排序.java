/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        int len=0;
        if(arr==null || (len=arr.length)==0) throw new IllegalArgumentException();
        Integer[] tmp = new Integer[len];
        for(int i=0; i<len; i++) tmp[i]=arr[i];
        Arrays.sort(tmp, (n1, n2)->{
            int cnt1 = this.cntOfOne(n1);
            int cnt2 = this.cntOfOne(n2);
            if(cnt1!=cnt2) return cnt1-cnt2;
            else return n1-n2;
        });
        int[] ret = new int[len];
        for(int i=0; i<len; i++) ret[i]=tmp[i];
        return ret;
    }

    private int cntOfOne(int num){
        if(num<0) throw new IllegalArgumentException();
        int ret=0;
        for(int i=0; i<32; i++){
            if((num&1)!=0) ret++;
            num>>=1;
        }
        return ret;
    }
}
// @lc code=end

