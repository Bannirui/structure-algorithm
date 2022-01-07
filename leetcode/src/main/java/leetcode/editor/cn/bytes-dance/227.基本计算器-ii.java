/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {

    // priority mappings for operation
    private Map<Character, Integer> priorityMap = new HashMap<>(){{
        put('+', 0);
        put('-', 0);
        put('*', 1);
        put('/', 1);
    }};

    public int calculate(String s) {
        // check
        int len=0;
        if(s==null ||(len=s.length())==0) throw new RuntimeException("err");
        s = s.replaceAll(" ","");
        if((len=s.length())==0) throw new RuntimeException("err");
        Stack<Long> numStack = new Stack<>(); // for number
        numStack.push(0L);
        Stack<Character> opStack = new Stack<>(); // for operation(+ - * / %)
        for(int i=0;i<len;i++){
            char curCh=s.charAt(i);
            if(curCh=='('){
                opStack.push(curCh);
            }else if(curCh==')'){
                while(!opStack.isEmpty()){
                    if(opStack.peek()=='('){
                        // (...) done
                        opStack.pop();
                        break;
                    }else{
                        this.calculate(numStack, opStack);
                    }
                }
            }else{ // num or op
                if(this.isNumber(curCh)){ // number
                    int number=0;
                    int j=i;
                    while(j<len&&this.isNumber(s.charAt(j))){
                        number=number*10+(s.charAt(j++)-'0');
                    }
                    i=j-1; // i will be increased 1 coz in for iterator
                    numStack.push((long)number);
                }else{ // operation
                    if(i>0&&(s.charAt(i-1)=='('||s.charAt(i-1)=='+'||s.charAt(i-1)=='-')) numStack.push(0L);
                    while(!opStack.isEmpty()&&opStack.peek()!='('){
                        if(this.priorityMap.get(opStack.peek())>=this.priorityMap.get(curCh)) this.calculate(numStack, opStack);
                        else break;
                    }
                    opStack.push(curCh);
                }
            }

        }
        // iterator end
        while(!opStack.isEmpty()) this.calculate(numStack, opStack);
        //return Integer.valueOf(String.valueOf(numStack.pop()));
        return (int)numStack.pop().intValue();

    }

    private boolean isNumber(char ch){
        return Character.isDigit(ch);
    }

    private void calculate(Stack<Long> numStack, Stack<Character> opStack){
        if(numStack.isEmpty() || numStack.size()<2) return;
        if(opStack.isEmpty()) return;
        long num2=numStack.pop();
        long num1=numStack.pop();
        char op = opStack.pop();
        long ret=0;
        if(op=='+') ret=num1+num2;
        else if(op=='-') ret=num1-num2;
        else if(op=='*') ret=num1*num2;
        else if(op=='/') ret=num1/num2;
        else{
            // ignore
        }
        numStack.push(ret);
    }
}
// @lc code=end

