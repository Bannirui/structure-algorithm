/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        // 字典序
        Integer[] numList = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            numList[i] = nums[i];
        }
        Arrays.sort(numList, (num1, num2)->{
            // num1 num2
            // num2 num1
            long sortedNum1 = this.add(num1, num2);
            long sortedNum2 = this.add(num2, num1);
            // 降序
            if(sortedNum1>sortedNum2){
                return -1;
            }else if(sortedNum1<sortedNum2){
                return 1;

            }else{
                return 0;
            }
        });
        // 判断首个元素是否是0
        if(numList[0]==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int num: numList){
            sb.append(num);
        }
        return sb.toString();
    }

    // 拼接 num1 num2
    private long add(int num1, int num2){
        int bits2 = this.bits(num2);
        long num = (long)num1;
        while(bits2!=0){
            num*=10;
            bits2--;
        }
        return num+num2;
    }

    // 十进制数的位数
    private int bits(int num){
        if(num==0){
            return 1;
        }
        int cnt=0;
        while(num!=0){
            cnt++;
            num/=10;
        }
        return cnt;
    }
}
// @lc code=end

