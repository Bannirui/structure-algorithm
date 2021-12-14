/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        Automaton automaton=new Automaton();
        for(int i=0;i<s.length();i++){
            automaton.get(s.charAt(i));
        }
        return (int)(automaton.getSign()*automaton.getAns());
    }

    private static class Automaton{
        private int sign = 1;
        private long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>(){{
            put("start", new String[]{"start","signed","in_number","end"});
            put("signed", new String[]{"end","end","in_number","end"});
            put("in_number", new String[]{"end","end","in_number","end"});
            put("end", new String[]{"end","end","end","end"});
        }};

        public int getSign(){
            return this.sign;
        }

        public long getAns(){
            return this.ans;
        }

        public void get(char c){
            this.state=this.table.get(this.state)[this.getCol(c)];
            if(Objects.equals("in_number",this.state)){
                this.ans=this.ans*10+c-'0';
                this.ans=this.sign==1?Math.min(this.ans,(long)Integer.MAX_VALUE):Math.min(this.ans,-(long)Integer.MIN_VALUE);
            }else if(Objects.equals("signed",this.state)){
                this.sign=c=='+'?1:-1;
            }
        }

        private int getCol(char c){
            if(c==' '){
                return 0;
            }else if(c=='+'||c=='-'){
                return 1;
            }else if(Character.isDigit(c)){
                return 2;
            }else{
                return 3;
            }
        }
    }
}
// @lc code=end
