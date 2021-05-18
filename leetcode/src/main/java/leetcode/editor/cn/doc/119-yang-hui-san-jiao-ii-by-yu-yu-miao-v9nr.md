# 方法：滚动数组

```
/**
 * 方法：滚动数组
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //重复利用数组list，大小直接初始化为k
        List<Integer> list = new ArrayList<>(rowIndex+1);

        for(int i=1;i<=rowIndex + 1;i++){
            //对于每一行的计算，要从后往前计算，因为总是会用到前面的数据的，所以从前往后覆盖
            //并且从倒数第二个开始计算
            for(int j=i-2;j>0;j--){
                list.set(j,list.get(j)+list.get(j-1));
            }

            //最终再在末尾添加一个1
            list.add(1);
        }

        return list;
    }
}
```
![image.png](https://pic.leetcode-cn.com/1608889716-EfszKI-image.png)
时间复杂度：O(n^2)
空间复杂度：O(n)