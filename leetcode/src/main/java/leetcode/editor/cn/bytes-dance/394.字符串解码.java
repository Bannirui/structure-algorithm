/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        return this.iterator(s);        
    }

    private String iterator(String s){
        // double stack
        int len = 0;
        if(s==null || (len=s.length())==0) return "";
        Stack<Integer> nums = new Stack<>();
        Stack<Character> rets = new Stack<>();
        for(int i=0; i<len; i++){ // num [ char ]
            char curCh = s.charAt(i);
            if(curCh==']'){ // close
                this.genStr(nums, rets);
            }else if(this.isNum(curCh)){ // num
                int j=i;
                int num=0;
                while(j<len && this.isNum(s.charAt(j))) num=num*10+(s.charAt(j++)-'0');
                nums.push(num);
                i=j-1; // reset
            }else if(curCh=='['){ // open
                rets.push(curCh);
            }else{ // char
                rets.push(curCh);
            }
        }
        while(!nums.isEmpty()) this.genStr(nums, rets);
        if(rets.isEmpty()) throw new RuntimeException("err: rets");
        StringBuilder sb = new StringBuilder();
        while(!rets.isEmpty()) sb.append(rets.pop());
        return sb.reverse().toString();
    }

    private void genStr(Stack<Integer> nums, Stack<Character> rets){
        if(nums.isEmpty() || rets.isEmpty() || rets.peek().equals("[")) throw new RuntimeException("err: genStr");
        StringBuilder sb = new StringBuilder();
        while(!rets.isEmpty() && rets.peek()!='[') sb.append(rets.pop());
        rets.pop(); // [
        String tmp = sb.reverse().toString();
        int cnt = nums.pop();
        String ret = "";
        while(cnt!=0){
            ret+=tmp;
            cnt--;
        }
        for(int i=0;i<ret.length();i++) rets.push(ret.charAt(i));
    }

    private boolean isNum(char ch){
        return Character.isDigit(ch);
    }
}
// @lc code=end

