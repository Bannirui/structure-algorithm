### 解题思路
看大佬的：
作者：yfxu_0209
链接：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/chun-c-0ms-er-xiang-shi-jie-ti-jian-dan-yi-dong-by/
来源：力扣（LeetCode）

思路：
杨辉三角的每一行元素值为二项式(1+x)^n中展开式中各项系数
![Snipaste_2020-12-21_14-29-27.png](https://pic.leetcode-cn.com/1608532225-VJuNBu-Snipaste_2020-12-21_14-29-27.png)
那么从第一项即可推测出后续每一项元素值：ret[k] = ((n - (k - 1)) / ((k - 1) + 1)) * ret[k - 1]

知识点：
二项式定理、递归？、二维数组、二重指针
### 代码
```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getRow(int rowIndex, int* returnSize){
    
    int i;

    /* 返回数组长度为rowIndex + 1
     * 因为rowIndex为当前行数(从0开始)
     */
    int *ret = calloc(rowIndex + 1, sizeof(int));

    /* 返回第rowIndex行的元素个数也是索引rowIndex + 1个 */
    *returnSize = rowIndex + 1;

    /* 第一项为1 */
    ret[0] = 1;

    /* 使用杨辉三角的定义来求：
     * (1 + x)^n中每一项的系数为杨辉三角当前行的每一项系数
     * 那么k项与k-1项存在关系为：k属于[1,n]
     * ret[k] = ((n - (k - 1)) / ((k - 1) + 1)) * ret[k - 1]
     */
    for (i = 1; i <= rowIndex; i++) {
        ret[i] = (long)ret[i - 1] * (rowIndex- i + 1) / i;
    }

    return ret;
}
```