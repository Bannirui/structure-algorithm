/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        int len=0;
        if(path==null || (len=path.length())==0 || path.charAt(0)!='/') throw new IllegalArgumentException();
        Deque<String> q = new LinkedList<>();
        String[] arr = path.split("/");
        for(String s: arr) {
            if(s.equals("")) continue;
            if(s.equals("..")){
                if(!q.isEmpty()) q.pollFirst();
            }else if(s.equals(".")) continue;
            else q.offerFirst(s);
        }
        String ret="";
        while(!q.isEmpty()) {
            ret+="/";
            ret+=q.pollLast();
        }
        return ret.equals("")?"/":ret;
    }
}
// @lc code=end

