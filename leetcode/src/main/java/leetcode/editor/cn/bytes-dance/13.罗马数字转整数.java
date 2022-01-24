/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        Map<Character,Integer> m = new HashMap<Character,Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ret=0;
        for(int i=0;i<len;i++){
            Integer val=m.get(s.charAt(i));
            if(val==null) throw new IllegalArgumentException();
            Integer nextVal;
            if(i+1<len && (nextVal=m.get(s.charAt(i+1)))!=null && val<nextVal) ret-=val;
            else ret+=val;
        }
        return ret;
    }
}
// @lc code=end

