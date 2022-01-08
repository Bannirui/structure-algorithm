/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {

    // operation priority, oder by int
    private Map<Character, Integer> opPriority = new HashMap<Character, Integer>(){{
        put('+', 0);
        put('-', 0);
        put('*', 1);
        put('/', 1);
    }};

    public int calculate(String s) {
        if(s==null || s.length()==0) throw new RuntimeException("err: param");
        s = s.replaceAll(" ", "");
        Stack<Long> nums = new Stack<Long>(){{
            push(0L);
        }}; // record the num
        Stack<Character> ops = new Stack<>(); // record the operator
        int len = s.length();
        for(int i=0; i<len; i++){ // iterator: nums + - * / ( )
            char curCh = s.charAt(i);
            if(curCh=='(') ops.push(curCh); // (
            else if(curCh==')'){ // ), cal util the open
                while(!ops.isEmpty()&&ops.peek()!='('){
                    this.cal(nums, ops);
                }
                if(ops.isEmpty() || ops.peek()!='(') throw new RuntimeException("err");
                ops.pop(); // (
            }else{ // num or op
                if(this.isNum(curCh)){ // num
                    int num=0;
                    int idx=i;
                    while(idx<len && this.isNum(s.charAt(idx))) num=num*10+(s.charAt(idx++)-'0');
                    nums.push((long)num);
                    i=idx-1;
                }else{ // op
                    if(i>0&&(s.charAt(i-1)=='(' ||s.charAt(i-1)=='+'||s.charAt(i-1)=='-')) nums.push(0L);
                    while(!ops.isEmpty() && ops.peek()!='('){
                        if(opPriority.get(ops.peek())>=opPriority.get(curCh)) this.cal(nums, ops);
                        else break;
                    }
                    ops.push(curCh);
                }
            }
        }
        while(!ops.isEmpty()){
            this.cal(nums, ops);
        }
        if(nums.isEmpty()) throw new RuntimeException("err");
        return nums.pop().intValue();
    }

    private boolean isNum(char ch){
        return Character.isDigit(ch);
    }

    private void cal(Stack<Long> nums, Stack<Character> ops){
        if(ops.isEmpty() || nums.isEmpty() || nums.size()<2) throw new RuntimeException("err");
        char op = ops.pop();
        long n2 = nums.pop();
        long n1 = nums.pop();
        Long ret = 0L;
        if(op=='+') ret=n1+n2;
        else if(op=='-') ret=n1-n2;
        else if(op=='*') ret=n1*n2;
        else if(op=='/') ret=n1/n2;
        else{
            // ignore
        }
        // record the cal result
        nums.push(ret);
    }
}
// @lc code=end

