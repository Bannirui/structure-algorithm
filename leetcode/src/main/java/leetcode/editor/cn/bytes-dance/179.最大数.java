/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err: param");
        Integer[] arr = new Integer[len];
        for(int i=0; i<len; i++) arr[i]=nums[i];
        Arrays.sort(arr, (n1, n2)->{
            int n12=this.genNum(n1, n2);
            int n21=this.genNum(n2, n1);
            return n21-n12;
        });
        if(arr[0]==0) return "0"; // corner
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<len; i++) ret.append(arr[i]);
        return ret.toString();
    }

    private int genNum(int n1, int n2){
        int len2=this.len4Num(n2);
        while(len2!=0){
            n1*=10;
            len2--;
        }
        return n1+n2;
    }

    private int len4Num(int num){
        if(num<0) throw new RuntimeException("num must be positive");
        if(num==0) return 1;
        int ret=0;
        while(num != 0){
            ret++;
            num/=10;
        }
        return ret;
    }
}
// @lc code=end

