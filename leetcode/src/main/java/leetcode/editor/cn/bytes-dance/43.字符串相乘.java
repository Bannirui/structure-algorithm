/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int len1=0, len2=0;
        if(num1==null || (len1=num1.length())==0 || num2==null || (len2=num2.length())==0) throw new IllegalArgumentException();
        if("0".equals(num1) || "0".equals(num2)) return "0";
        String ret="0";
        for(int j=len2-1;j>=0;j--){
            StringBuilder cur = new StringBuilder();
            for(int i=len2-1;i>j;i--) cur.append(0);

            int y=num2.charAt(j)-'0';
            int take=0;
            for(int i=len1-1;i>=0;i--){
                int x=num1.charAt(i)-'0';
                int p = x*y+take;
                cur.append(p%10);
                take=p/10;
            }
            if(take != 0) cur.append(take);
            ret = this.add(ret, cur.reverse().toString());
        }
        return ret;
    }

    private String add(String num1, String num2){
        int len1=0, len2=0;
        if(num1==null || (len1=num1.length())==0 || num2==null || (len2=num2.length())==0) throw new IllegalArgumentException();
        int i=len1-1;
        int j=len2-1;
        int take=0;
        StringBuilder ret = new StringBuilder();
        while(i>=0 || j>=0 || take>0){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int sum=x+y+take;
            ret.append(sum%10);
            take=sum/10;
            i--;
            j--;
        }
        return ret.reverse().toString();
    }
}
// @lc code=end

