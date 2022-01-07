/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        int len=0;
        if(s==null||(len=s.length())==0) throw new RuntimeException("err: param");
        Deque<Character> q = new LinkedList<>();
        for(int i=0; i<len; i++){
            if(!q.isEmpty()&&q.peekLast()==s.charAt(i)){
                q.pollLast(); 
            }else{
                q.offerLast(s.charAt(i));
            }
        }
        StringBuilder ret = new StringBuilder();
        while(!q.isEmpty()){
            ret.append(q.pollFirst());
        }
        return ret.toString();
    }
}
// @lc code=end

