/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.chars().filter(o->o=='.').count()==3) return this.validIP4(queryIP);
        else if(queryIP.chars().filter(o->o==':').count()==7) return this.validIP6(queryIP);
        else return "Neither";
    }

    private String validIP4(String ip){
        String[] nums = ip.split("\\.", -1);
        for(String num: nums){
            if(num.length()==0 || num.length()>3) return "Neither";
            if(num.charAt(0)=='0' && num.length()!=1) return "Neither";
            for(char ch: num.toCharArray()) if(!Character.isDigit(ch)) return "Neither";
            if(Integer.parseInt(num)>255) return "Neither";
        }
        return "IPv4";
    }

    private String validIP6(String ip){
        String[] nums = ip.split(":",-1);
        String hexdigits = "0123456789abcdefABCDEF";
        for(String num: nums){
            if(num.length()==0||num.length()>4) return "Neither";
            for(char ch: num.toCharArray()) if(hexdigits.indexOf(ch)==-1) return "Neither";
        }
        return "IPv6";
    }
}
// @lc code=end

