### 解题思路
执行用时：
1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：
35.4 MB, 在所有 Java 提交中击败了85.97%的用户

关键不是在于要找到相等的值,而是找到最接近而不大于n的值

### 代码

```java
class Solution {
    public int arrangeCoins(long n) {
        //改变一些参数类型,防止int溢出
        if(n<3)
        {
            return 1;
        }
        else
        {
            long left=0;
            long right=n;
            long temp=0;
            while(left<=right)
            {
                long mid=(left+right)/2;
                //基本的等差数列求和
                if(mid*mid+mid>2*n)
                {
                    right=mid-1;
                }
                else
                {
                    //先不急着return,万一我们没有找到最接近的呢?
                    temp=mid;
                    left=mid+1;
                }
            }
            return (int)temp;
        }
    }
}
```