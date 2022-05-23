/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {

    Set<String> deads=new HashSet<>();
    int minRet=-1;

    public int openLock(String[] deadends, String target) {
        String src="0000";
        if(src.equals(target)) return 0;
        for(String dead: deadends) this.deads.add(dead);
        if(this.deads.contains(src)) return -1;
        
        Queue<String> q = new LinkedList<String>(){{
            offer(src);
        }};
        Set<String> seen = new HashSet<String>(){{
            add(src);
        }};
        int ret=0;
        while(!q.isEmpty()){
            ret++;
            int size=q.size();
            for(int i=0;i<size;i++){
                String s = q.poll();
                for(String nextS: this.next(s)){
                    if(this.deads.contains(nextS)) continue;
                    if(seen.contains(nextS)) continue;
                    if(nextS.equals(target)) return ret;
                    q.offer(nextS);
                    seen.add(nextS);
                }
            }
        }
        return -1;
    }

    // 拨动一次 可能往前拨动 可能往后拨动
    private List<String> next(String s){
        List<String> ret = new ArrayList<>();
        // 4个数字都有可能往前或往后
        char[] chArr = s.toCharArray();
        for(int i=0, len=chArr.length; i<len; i++){
            char preCh = chArr[i];
            char newChPre = this.pre(preCh);
            chArr[i]=newChPre;
            ret.add(new String(chArr));
            char newChNext = this.next(preCh);
            chArr[i]=newChNext;
            ret.add(new String(chArr));
            chArr[i]=preCh;
        }
        return ret;
    }

    private char pre(char c){
        return c == '0'? '9' : (char)(c-1);
    }

    private char next(char c){
        return c == '9'? '0' : (char)(c+1);
    }
}
// @lc code=end

