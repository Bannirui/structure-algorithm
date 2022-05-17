/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int lenS=0, lenT=0;
        if(s==null || (lenS=s.length())==0 || t==null || (lenT=t.length())==0) throw new IllegalArgumentException();
        // [start...end] of substring
        int start=0, end=-1;
        int min=Integer.MAX_VALUE;
        int S=0,E=0;
        // cnt table for s
        Map<Character, Integer> cntWin = new HashMap<>();
        Map<Character, Integer> cntMap4T = this.initCntMap(t);
        while(end<lenS){
            // increase the end to resize the win
            end++;
            if(end<lenS && cntMap4T.containsKey(s.charAt(end)))
                cntWin.put(s.charAt(end),cntWin.getOrDefault(s.charAt(end),0)+1);
            while((start<=end) && this.doJudge(cntMap4T, cntWin)){
                // try to record
                if(end-start<min){
                    min=end-start;
                    S=start;
                    E=end;
                }
                // increase the start to resize the win
                char startCh = s.charAt(start);
                if(cntWin.containsKey(startCh)) cntWin.put(startCh, cntWin.get(startCh)-1);
                start++;
            }
        
        }
        return min==Integer.MAX_VALUE?"":s.substring(S,E+1);
    }

    private Map<Character, Integer> initCntMap(final String s){
        int len=0;
        if(s==null || (len=s.length())==0) return null;
        Map<Character, Integer> ret = new HashMap<>();
        for(int i=0;i<len;i++) {
            char curCh = s.charAt(i);
            ret.put(curCh, ret.getOrDefault(curCh,0)+1);
        }
        return ret;
    }

    private boolean doJudge(Map<Character, Integer> bound, Map<Character, Integer> src){
        Iterator<Map.Entry<Character, Integer>> it = bound.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character, Integer> next = it.next();
            if(src.getOrDefault(next.getKey(),0) < next.getValue()) return false;
        }
        return true;
    }
}
// @lc code=end

