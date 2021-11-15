/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        // queue
        Deque<String> q = new LinkedList<>();
        int idx=0;
        while(idx<path.length()){
            // ignore /
            while(idx<path.length()&&path.charAt(idx)=='/'){
                idx++;
            }
            if(idx==path.length()){
                break;
            }
            // sub
            int subStart=idx;
            while(idx<path.length()&&path.charAt(idx)!='/'){
                idx++;
            }
            // /
            String sub = path.substring(subStart, idx);
            if(Objects.equals(sub, ".")){
                // todo
            }else if(Objects.equals(sub, "..")){
                // poll
                if(!q.isEmpty()){
                    q.pollLast();
                }
            }else{
                // offer
                q.offerLast(sub);
            }
        }
        // pop
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while(!q.isEmpty()){
            sb.append(q.pollFirst());
            if(!q.isEmpty()){
                sb.append("/");
            }
        }
        
        return sb.toString();
    }
}
// @lc code=end

