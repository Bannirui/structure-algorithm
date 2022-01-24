/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        int len1=0, len2=0;
        if(version1==null || version2==null || (len1=version1.length())==0 || (len2=version2.length())==0) throw new IllegalArgumentException();
        int i=0, j=0;
        while(i<len1 || j<len2){
            int sum1=0;
            for(;i<len1 && version1.charAt(i)!='.';i++) sum1=sum1*10+(version1.charAt(i)-'0');
            i++;
            int sum2=0;
            for(;j<len2&&version2.charAt(j)!='.';j++) sum2=sum2*10+(version2.charAt(j)-'0');
            j++;
            if(sum1!=sum2) return sum1>sum2? 1:-1;
        }
        return 0;
    }
    
}
// @lc code=end

