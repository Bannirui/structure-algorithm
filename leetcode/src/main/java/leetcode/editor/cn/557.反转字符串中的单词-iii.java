/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        String res="";
        for(int i=0;i<sArr.length;i++){
            String tmp =this.reverse(sArr[i]);
            res+=tmp;
            if(i!=sArr.length-1){
                res+=" ";
            }
        }
        return res;
    }

    private String reverse(String word){
        char[] wordArr = word.toCharArray();
        int l=0, r=wordArr.length-1;
        while(l<r){
            char tmp = wordArr[l];
            wordArr[l]=wordArr[r];
            wordArr[r]=tmp;
            l++;
            r--;
        }
        return new String(wordArr);
    }
}
// @lc code=end

