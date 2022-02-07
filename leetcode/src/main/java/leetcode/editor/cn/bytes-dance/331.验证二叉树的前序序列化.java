/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        int len=0;
        if(preorder==null || (len=preorder.length())==0) throw new IllegalArgumentException();
        int slots=1;
        int idx=0;
        while(idx<len){
            if(slots==0) return false;
            char curCh=preorder.charAt(idx);
            if(curCh==',') idx++;
            else if(curCh=='#'){
                slots--;
                idx++;
            }else{
                while(idx<len&&preorder.charAt(idx)!=',') idx++;
                slots=slots-1+2;
            }
        }
        return slots==0;
    }
}
// @lc code=end

