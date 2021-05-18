### 解题思路
1. 使用`max1`表示第一大的数，`max2`表示第二大的数，`max3`表示第三大的数
2. 遍历数组，如果当前数字是重复的就跳过，否则更新`max1`，`max2`和`max3`
3. 遍历结束，如果`max3`依然是初始的最小值，说明第三大的数不存在，返回`max1`，否则返回`max3`
### 代码

```java
class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == max1 || num == max2 || num == max3) continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }
}
```