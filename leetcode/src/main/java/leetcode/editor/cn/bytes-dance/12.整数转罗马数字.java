/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String ret = "";
        for(int i=0; i<nums.length; i++){
            while(num>=nums[i]){
                ret+=strs[i];
                num-=nums[i];
            }
            if(num==0) break;
        }
        return ret;
    }
}
// @lc code=end

