## 思路

一看题目就是一个笛卡尔积问题。

即给你一个数字 num， 我可以将其分成两部分。其中一部分（不妨设为a）给小时，另一部分给分（就是 num - a）。 最终的结果就是 a 能表示的所有小时的集合和 num - a所能表示的分的集合的笛卡尔积。

用代码表示就是：

```py
# 枚举小时
for a in possible_number(i):
    # 小时确定了，分就是 num - i
    for b in possible_number(num - i, True):
        ans.add(str(a) + ":" + str(b).rjust(2, '0'))
```

枚举所有可能的 (a, num - a)  组合即可。

核心代码：

```py
for i in range(min(4, num + 1)):
    for a in possible_number(i):
        for b in possible_number(num - i, True):
            ans.add(str(a) + ":" + str(b).rjust(2, '0'))
```

## 代码

```py
class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
        def possible_number(count, minute=False):
            if count == 0: return [0]
            if minute:
                return filter(lambda a: a < 60, map(sum, combinations([1, 2, 4, 8, 16, 32], count)))
            return filter(lambda a: a < 12, map(sum, combinations([1, 2, 4, 8], count)))
        ans = set()
        for i in range(min(4, num + 1)):
            for a in possible_number(i):
                for b in possible_number(num - i, True):
                    ans.add(str(a) + ":" + str(b).rjust(2, '0'))
        return list(ans)
```


进一步思考，实际上，我们要找的就是 a 和 b 相加等于 num，并且 a 和 b 就是二进制表示中 1 的个数。 因此可以将逻辑简化为：


```py
class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
        return [str(a) + ":" + str(b).rjust(2, '0') for a in range(12) for b in range(60) if (bin(a)+bin(b)).count('1') == num]
```
