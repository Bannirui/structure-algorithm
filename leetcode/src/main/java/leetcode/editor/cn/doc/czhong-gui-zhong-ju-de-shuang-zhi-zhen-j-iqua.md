![WX20210322-090916@2x.png](https://pic.leetcode-cn.com/1616375374-ZLYGAg-WX20210322-090916@2x.png)


### 解题思路
双指针
1. 分别去指向前面和后面的元音位置
2. 然后交换
3. 继续遍历，直到两个指针相等为止

### 代码

```cpp

class Solution {
private:
    unordered_set<char> ss{'a','e','i','o','u','A','E','I','O','U'};
public:
    string reverseVowels(string s) {
        int i = 0;
        int j = s.size() - 1;
        while (i < j)
        {
            while (i < j && ss.find(s[i]) == ss.end())
            {
                ++i;
            }
            while (i < j && ss.find(s[j]) == ss.end())
            {
                --j;
            }
            if (i < j)
            {
                swap(s[i], s[j]);
                ++i;
                --j;
            }
        }

        return s;
    }
};
```