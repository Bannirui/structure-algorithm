![1608083505(1).png](https://pic.leetcode-cn.com/1608085370-tYjJiG-1608083505\(1\).png)
第一种：HashMap + HashSet,，这里简单说一下
1：判断字符串 pattern 与 s 的长度是否相等，不等则返回 false；
2：接下来遍历 pattern，用 pattern 的单个字符做为 map 的 key，s 的单个单词作为 map 的 value；这样只处理了 pattern 到 s 的映射，abba，dog dog dog dog 这种无法满足；
3：因此我们用一个 set 来存储 s 的单词，保证每个单词对应的 pattern 的字符也是唯一的；该步骤也可用上面2步骤重复一遍解决，把 pattern 跟 s 调换位置后从新调用方法即可；
![1608083704(1).jpg](https://pic.leetcode-cn.com/1608085362-JFrIrV-1608083704\(1\).jpg)

第二种方法：一个 HashMap 即可。大概思路如下：
1：我们只管 pattern 与 s 之间字符一一对应即可，看一个例子 pattern=abba，s=dog cat cat dog；第一次调用 map 的 put 方法时返回 null，如果是第 n 次调用的话即返回第 n-1 次的 value，很明显 valua 至关重要，因为 pattern 与 s 的长度是相等的，所以数组下标 i 是一一对应的，我们用 i 做 map 的 value 即可；
2：所以我们直接遍历 pattern 就可以了，第一次 map.put(a)跟 map.put(dog)都是返回 null，第二次 map.put(a)跟 map.put(dog)都是返回 0，以此类推下去即可；
3：这种解决问题的方法的重点在于利用两个字符串的下标是一一对应的，其次则是利用put的返回值；
代码如下
![1608083787(1).jpg](https://pic.leetcode-cn.com/1608086247-AhWIAv-1608083787\(1\).jpg)


