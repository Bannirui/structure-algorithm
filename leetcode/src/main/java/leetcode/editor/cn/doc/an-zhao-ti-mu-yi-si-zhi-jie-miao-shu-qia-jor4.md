### 解题思路
按照题目思路，第n个数是对第n-1个数字的描述，那么拿到dp[n - 1] (dp[n - 1]表示第n个数的描述)，那么dp[n] 直接描述dp[n -1]即可，具体描述函数为describe，不难看懂。

### 代码

```java
class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String[] dp = new String[n + 1];
        dp[1] = "1";
        dp[2] = "11";
        for (int i = 3; i <= n; i++) {
            dp[i] = describe(dp[i - 1]);
        }
        return dp[n];
    }

    private String describe(String pre) {
        StringBuilder ans = new StringBuilder();
        int len = pre.length();
        int num = pre.charAt(0) - '0';
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (pre.charAt(i) == pre.charAt(i - 1)) {
                count++;
            } else {
                ans.append(count);
                ans.append(num);
                num = pre.charAt(i) - '0';
                count = 1;
            }
            if (i == len - 1) {
                ans.append(count);
                ans.append(num);
            }
        }
        return ans.toString();
    }
}
```