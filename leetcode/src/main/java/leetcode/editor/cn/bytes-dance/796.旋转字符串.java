/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s==null || goal==null) throw new IllegalArgumentException();
        int lenS=0, lenG=0;
        lenS=s.length();
        lenG=goal.length();
        if(lenS!=lenG) return false;
        if(lenS==0 || lenG==0) return false;
        s+=s; // double s
        int[] next = new int[lenS<<1];
        this.genNext(next, s); // next
        int i=0, j=0;
        lenS<<=1;
        while(i<lenS && j<lenG){
            if(j==-1||s.charAt(i)==goal.charAt(j)){
                i++;
                j++;
            }else j=next[j];
        }

        if(j>=lenG) return true;
        else return false;
    }

    private void genNext(int[] next, String pat){
        next[0]=-1; // base case
        int j=0;
        int k=-1;
        while(j<pat.length()-1){
            if(k==-1||pat.charAt(j)==pat.charAt(k)){
                j++;
                k++;
                if(pat.charAt(j)==pat.charAt(k)) next[j]=next[k];
                else next[j]=k;
            }else k=next[k];
        }
    }
}
// @lc code=end

