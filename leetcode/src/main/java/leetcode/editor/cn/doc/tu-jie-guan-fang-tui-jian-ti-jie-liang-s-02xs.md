![官方推荐题解](https://pic.leetcode-cn.com/1615649992-QvMuco-%E6%9C%AA%E6%A0%87%E9%A2%98-1.png)

### 解题思路

1. 遍历 *nums* , 判断每个数字和 *target* 的差值，是否存在于哈希表中，若存在，返回两数字的索引即可，若不存在，记录当前数字在哈希表中。
2. 哈希表存储格式：数字 => 所在 *nums* 索引 。

### 图解演示

制作中...

### 示例代码

```javascript
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = new Map();
    for(let i = 0, len = nums.length; i < len; i++){
        // 如果哈希表存有能与当前元素相加为 target 的数字，则直接皆大欢喜，返回结果
        if(map.has(target - nums[i])){
            return [map.get(target - nums[i]), i];
        // 如果没有，将当前数字存入哈希，值为当前数字在数组中的索引
        }else{
            map.set(nums[i], i);
        }
    }
    return [];
};
```

* 时间复杂度：*O(n)*，遍历 nums 的操作次数。
* 空间复杂度：*O(n)*，map 的存储开销。

## 后序

若该题解对你有帮助，请不要吝啬你的赞哦，喜欢的可以加个关注，有关注，不迷路 🎉 。