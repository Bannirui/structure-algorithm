/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int len=0;
        if(s==null || (len=s.length())==0 || numRows<=0) throw new IllegalArgumentException();
        if(numRows==1) return s;

        StringBuilder[] data = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) data[i]=new StringBuilder();

        int r=0;
        boolean flag=true;
        for(int i=0;i<len;i++){
            data[r].append(s.charAt(i));
            if(flag){
                if(r==numRows-1){
                    r--;
                    flag=!flag;
                }else r++;
            }else{
                if(r==0){
                    r++;
                    flag=!flag;
                }else r--;
            }
        }

        StringBuilder ret = new StringBuilder();
        for(int i=0;i<numRows;i++){
            StringBuilder sb=data[i];
            if(sb.length()>0) ret.append(sb);
        }
        return ret.toString();
    }
}
// @lc code=end

