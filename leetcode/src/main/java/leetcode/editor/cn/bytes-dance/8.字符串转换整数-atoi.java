/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) return 0;
        Automaton automaton = new Automaton();
        for(int i=0; i<len; i++) automaton.get(s.charAt(i));
        return (int)(automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0L;

    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start","signed","number","end"});
        put("signed", new String[]{"end", "end", "number", "end"});
        put("number", new String[]{"end","end","number","end"});
        put("end", new String[]{"end","end","end","end"});
    }};

    public void get(char c){
        this.state = this.table.get(this.state)[this.getCol(c)];
        if("number".equals(state)){
            this.ans=this.ans*10+(c-'0');
            if(this.sign==1) this.ans=Math.min(this.ans,(long)Integer.MAX_VALUE);
            else this.ans=Math.min(this.ans,-(long)Integer.MIN_VALUE);
        }else if("signed".equals(this.state)){
            if(c=='+') this.sign=1;
            else this.sign=-1;
        }
    }

    // 状态表脚标
    private int getCol(char c){
        if(c==' ') return 0;
        else if(c=='+' || c=='-') return 1;
        else if(Character.isDigit(c)) return 2;
        return 3;
    }
}
// @lc code=end

