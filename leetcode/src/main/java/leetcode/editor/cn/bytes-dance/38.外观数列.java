/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if(n<=0) throw new IllegalArgumentException();
        // base case
        if(n==1) return "1";
        else{
            String ret = this.countAndSay(n-1);
            int len=0;
            if(ret==null || (len=ret.length())==0) throw new IllegalArgumentException();

            Deque<Character> valQ = new LinkedList<>(); // 字符
            Deque<Integer> cntQ = new LinkedList<>(); // 字符计数
            for(int i=0;i<len;i++){
                char ch=ret.charAt(i);
                if(!valQ.isEmpty() && valQ.peekLast()==ch) cntQ.offerLast(cntQ.pollLast()+1);
                else {
                    valQ.offerLast(ch);
                    cntQ.offerLast(1);
                }
            }
            if(valQ.isEmpty() || cntQ.isEmpty() || valQ.size() != cntQ.size()) throw new IllegalArgumentException();
            StringBuilder sb = new StringBuilder();
            while(!cntQ.isEmpty()){
                sb.append(cntQ.pollFirst());
                sb.append(valQ.pollFirst());
            }
            if(sb.length()==0) throw new IllegalArgumentException();
            return sb.toString();
        }
    }
}
// @lc code=end

