
### 1，动态规划解决

这题是让求完成一笔交易所获得的最大利润，首先我们来看一下使用动态规划该怎么解决，动态规划还是那常见的几个步骤



- 确定状态
- 找到转移公式
- 确定初始条件以及边界条件
- 计算结果

<br>

我们来定义一个二维数组```dp[length][2]```，其中```dp[i][0]```表示第```i+1```天（```i是从0开始的```）结束的时候没持有股票的最大利润，```dp[i][1]```表示第```i+1```天结束的时候持有股票的最大利润。

<br>


如果我们要求第```i+1```天结束的时候没持有股票的最大利润```dp[i][0]```，那么会有两种情况。

第一种情况就是第```i+1```天我们即没买也没卖，那么最大利润就是第i天没持有股票的最大利润```dp[i-1][0]```。

第二种情况就是第i+1天我们卖了一支股票，那么最大利润就是第i天持有股票的最大利润（这个是负的，并且也不一定是第i天开始持有的，有可能在第i天之前就已经持有了）加上第i+1天卖出股票的最大利润，```dp[i-1][1]+prices[i]```。

<br>

很明显我们可以得出

```dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);```

<br>

同理我们可以得出第i+1天结束的时候我们持有股票的最大利润

```dp[i][1]=max(dp[i-1][1],-prices[i])；```

<br>

边界条件就是第1天的时候，如果我们不持有股票，那么

```dp[0][0]=0;```

如果持有股票，那么

```dp[0][1]=-prices[0];```

<br>

有了边界条件和递推公式，代码就很容易写出来了，来看下代码

```
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
        return 0;
    int length = prices.length;
    int[][] dp = new int[length][2];
    //边界条件
    dp[0][0]= 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < length; i++) {
        //递推公式
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    //毋庸置疑，最后肯定是手里没持有股票利润才会最大，也就是卖出去了
    return dp[length - 1][0];
}
```

<br>

### 2，代码优化

我们看到上面二维数组中**计算当天的最大利润只和前一天的利润有关**，所以没必要使用二维数组，只需要使用两个变量即可，一个表示当天持有股票的最大利润，一个表示当天没持有股票的最大利润，代码如下。

```
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
        return 0;
    int length = prices.length;
    int hold = -prices[0];//持有股票
    int noHold = 0;//不持有股票
    for (int i = 1; i < length; i++) {
        //递推公式
        noHold = Math.max(noHold, hold + prices[i]);
        hold = Math.max(hold, -prices[i]);
    }
    //毋庸置疑，最后肯定是手里没持有股票利润才会最大，
    //也就是卖出去了
    return noHold;
}
```

<br>

### 3，双指针解决

我们还可以使用两个指针，一个指针记录**访问过的最小值**（注意这里是**访问过**的最小值），一个指针一直往后走，然后计算他们的差值，保存最大的即可，这里就以示例1为例来画个图看下

![image.png](https://pic.leetcode-cn.com/1610415520-CwdtLW-image.png)
![image.png](https://pic.leetcode-cn.com/1610415531-OlyJTl-image.png)

原理比较简单，来看下代码

```
public static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
        return 0;
    int maxPro = 0;//记录最大利润
    int min = prices[0];//记录数组中访问过的最小值
    for (int i = 1; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        maxPro = Math.max(prices[i] - min, maxPro);
    }
    return maxPro;
}
```

<br>

### 4，单调栈解决

单调栈解决的原理很简单，我们要**始终保持栈顶元素是所访问过的元素中最小的**，如果当前元素小于栈顶元素，就让栈顶元素出栈，让当前元素入栈。如果访问的元素大于栈顶元素，就要计算他和栈顶元素的差值，我们记录最大的即可，代码如下。

```
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
        return 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(prices[0]);
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
        //如果栈顶元素大于prices[i]，那么栈顶元素出栈，
        //把prices[i]压栈，要始终保证栈顶元素是最小的
        if (stack.peek() > prices[i]) {
            stack.pop();
            stack.push(prices[i]);
        } else {
            //否则如果栈顶元素不大于prices[i]，就要计算
            //prices[i]和栈顶元素的差值
            max = Math.max(max, prices[i] - stack.peek());
        }
    }
    return max;
}
```

仔细看下就会明白这种解法其实就是双指针的另一种实现方式，只不过双指针使用的是一个变量记录访问过的最小值，而这里使用的是栈记录的。

<br>

### 5，参照最大子序和

在前面刚讲过最大子序和的问题，不明白的可以看下[486，动态规划解最大子序和](https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247489432&idx=2&sn=6e88498e416ed6cd93c702016c74d852&chksm=fb4184b8cc360dae36230766552209732035395792576c6bf78c556318531391974416f43b14&scene=21#wechat_redirect)，今天这题完全可以参照第486的解题思路。

<br>

假设数组的值是```[a,b,c,d,e,f]```，我们用数组的前一个值减去后一个值，得到的新数组如下

```[b-a,c-b,d-c,e-d,f-e]```

我们在新数组中随便找几个连续的数字相加就会发现一个规律，就是中间的数字都可以约掉，比如新数组中第1个到第4个数字的和是

```b-a+c-b+d-c+e-d=e-a。```

<br>

我们来看下示例1中得到的新数组，连续的最大值就是

```4+(-2)+3=5。```


![image.png](https://pic.leetcode-cn.com/1610415703-NWXMRp-image.png)

搞懂了上面的原理代码就简单多了，我们前面刚讲的最大子序和的代码如下
```
public int maxSubArray(int[] num) {
    int length = num.length;
    int cur = num[0];
    int max = cur;
    for (int i = 1; i < length; i++) {
        cur = Math.max(cur, 0) + num[i];
        //记录最大值
        max = Math.max(max, cur);
    }
    return max;
}
```
然后我们来对他进行修改一下，就是今天这题的答案了。

```
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
        return 0;
    int length = prices.length;
    int cur = 0;
    int max = cur;
    for (int i = 1; i < length; i++) {
        //这地方把prices[i]改为 prices[i] - prices[i - 1]即可
        cur = Math.max(cur, 0) + prices[i] - prices[i - 1];
        //记录最大值
        max = Math.max(max, cur);
    }
    return max;
}
```

<br>

### 6，暴力解决

这种是两两比较，保存计算的最大值即可，没啥可说的，虽然简单，但效率很差，看下代码

```
public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
        return 0;
    int maxPro = 0;
    for (int i = 0; i < prices.length; i++) {
        for (int j = i + 1; j < prices.length; j++) {
            maxPro = Math.max(maxPro, prices[j] - prices[i]);
        }
    }
    return maxPro;
}
```


<br>

#### 如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解