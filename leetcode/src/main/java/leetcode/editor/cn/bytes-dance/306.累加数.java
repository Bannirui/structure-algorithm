/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        int len=0;
        if(num==null || (len=num.length())==0) throw new IllegalArgumentException();
        return this.dfs(num, 0, new ArrayList<>());
    }

    // [0...idx) ok
    // [idx...)
    // path 当前的数字
    // ret 累加合格数字
    private boolean dfs(String num, int idx, List<List<Integer>> ret){
        if(num==null || ret==null) throw new IllegalArgumentException();
        // base case
        if(idx==num.length()) return ret.size()>=3;
        // [idx...len) 选当前数字 idx脚标处可能为0 [idx...idxBound)
        int idxBound = num.charAt(idx)=='0'?idx+1:num.length();
        List<Integer> curNum = new ArrayList<>();
        for(int i=idx;i<idxBound;i++){
            // [idx...i]
            curNum.add(num.charAt(i)-'0');
            int retSize = ret.size();
            if(retSize<2 || this.isValidSum(ret.get(retSize-2),ret.get(retSize-1),curNum)){
                List<List<Integer>> retCpy = new ArrayList<>(ret);
                retCpy.add(curNum);
                if(this.dfs(num, i+1, retCpy)) return true;
            }
        }
        return false;
    }

    // n1+n2==n3
    private boolean isValidSum(List<Integer> n1, List<Integer> n2, List<Integer> n3){
        if(n1==null || n2==null || n3==null) throw new IllegalArgumentException();
        List<Integer> sumList = new ArrayList<>();
        int n1Idx=n1.size()-1;
        int n2Idx=n2.size()-1;
        int carry=0;
        while(n1Idx>=0 || n2Idx>=0){
            int n1Num = n1Idx>=0?n1.get(n1Idx--):0;
            int n2Num = n2Idx>=0?n2.get(n2Idx--):0;
            int sum = n1Num+n2Num+carry;
            sumList.add(0, sum%10);
            carry=sum/10;
        }
        if(carry>0) sumList.add(0, carry);
        if(sumList.size() != n3.size()) return false;
        for(int i=0;i<sumList.size();i++){
            if(sumList.get(i)!=n3.get(i)) return false;
        }
        return true;
    }
}
// @lc code=end

