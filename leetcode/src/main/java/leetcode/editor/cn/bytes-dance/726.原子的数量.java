/*
 * @lc app=leetcode.cn id=726 lang=java
 *
 * [726] 原子的数量
 */

// @lc code=start
class Solution {

    private int idx;
    private int len;

    public String countOfAtoms(String formula) {
        int len=0;
        if(formula==null || (len=formula.length())==0) throw new IllegalArgumentException();
        this.len=len;
        this.idx=0;
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<String, Integer>());
        while(this.idx<this.len){
            char curCh=formula.charAt(this.idx);
            if(curCh=='('){
                // 下一层
                this.idx++;
                stack.push(new HashMap<String,Integer>());
            }else if(curCh==')'){
                // 上一层重复次数
                this.idx++;
                Integer cnt=this.parseNum(formula);
                Map<String,Integer> preMap=stack.pop();
                Map<String,Integer> curMap=stack.peek();
                for(Map.Entry<String,Integer> entry:preMap.entrySet()){
                    String k=entry.getKey();
                    Integer v=entry.getValue(); // 上一层次数
                    curMap.put(k,curMap.getOrDefault(k,0)+v*cnt); // 当层
                }
            }else{
                // 解析当层
                String str=this.parseString(formula);
                Integer cnt=this.parseNum(formula);
                Map<String,Integer> curMap=stack.peek();
                curMap.put(str,curMap.getOrDefault(str,0)+cnt);
            }
        }
        if(stack.isEmpty()) throw new RuntimeException();
        Map<String, Integer> map = stack.pop();
        // sort
        TreeMap<String,Integer> treeMap =new TreeMap<String,Integer>(map);
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,Integer> entry: treeMap.entrySet()){
            String k=entry.getKey();
            Integer v=entry.getValue();
            sb.append(k);
            if(v==1) continue;
            sb.append(v);
        }
        return sb.toString();
    }

    private String parseString(String s){
        // 大写
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(this.idx++));
        while(this.idx<this.len && Character.isLowerCase(s.charAt(this.idx)))
            sb.append(s.charAt(this.idx++)); // 小写
        return sb.toString();
    }

    private Integer parseNum(String s){
        if(this.idx==this.len || !Character.isDigit(s.charAt(this.idx))) return 1;
        int ret=0;
        while(this.idx<this.len && Character.isDigit(s.charAt(this.idx))) ret=ret*10+(s.charAt(this.idx++)-'0');
        return ret;
    }
}
// @lc code=end

