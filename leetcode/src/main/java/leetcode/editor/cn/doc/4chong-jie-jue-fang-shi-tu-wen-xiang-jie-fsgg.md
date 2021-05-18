
### 1，解法一

每次循环的时候把n的最后一位数字（二进制的）截取掉，放到一个新的数字中的末尾，可以看下视频

![leet0190.mp4](3960b3dc-76e0-4ece-8b95-379f20376d8d)


来看下代码

```java
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //res先往左移一位，把最后一个位置空出来，
            //用来存放n的最后一位数字
            res <<= 1;
            //res加上n的最后一位数字
            res |= n & 1;
            //n往右移一位，把最后一位数字去掉
            n >>= 1;
        }
        return res;
    }
```


看一下运行结果
![image.png](https://pic.leetcode-cn.com/1615990942-GVmhaR-image.png)

<br>

我们还可以把上面的```|```改为```+```，原理都是一样的，看下

```java
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //res先往左移一位，把最后一个位置空出来，
            //用来存放n的最后一位数字
            res <<= 1;
            //res加上n的最后一位数字（这里改成加法）
            res += n & 1;
            //n往右移一位，把最后一位数字去掉
            n >>= 1;
        }
        return res;
    }
```



<br>




### 2，解法二

在java中int类型是32位的，这里用第1位和第32位交换，第2位和第31位交换……最终数字n的高16位会变为低16位，低16位会变为高16位，原理比较简单，来看下代码

```java
    public int reverseBits(int n) {
        int res = 0;
        //把低16位移到高16上
        for (int i = 0; i < 16; i++) {
            res |= (n & (1 << i)) << (31 - i * 2);
        }
        //把高16位移到低16位上
        for (int i = 16; i < 32; i++) {
            res |= (n & (1 << i)) >>> (i * 2 - 31);
        }
        return res;
    }
```


<br>


### 3，解法三

还可以不使用循环，就是前面16个和后面16个交换，然后前面16个和后面16个中的8个8个在交换……直到两两交换为止。

看下视频

![leet0190-1.mp4](a1aff41a-97e5-4127-8a1f-5cf812dd4b71)

来看下代码

```java
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
```

看一下运行结果

![image.png](https://pic.leetcode-cn.com/1616210059-lPbwof-image.png)




<br>


### 4，解法四

这种解法是Java中int的包装类Integer的一个方法，我把方法名改了，咋一看估计不太容易看懂，其实我们把下面的数字转化为二进制就能看明白了。

他是每2位之间相互交换，然后是每4位之间相互交换，接着是每8位之间相互交换，但最后不是每16位之间交换，而是把32位分为4个8位，这4个8位之间相互交换，具体也可以看下

[《364，位1的个数系列（一）》](http://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247486495&idx=1&sn=840f5d87a7ed767bdc27b5c97e36bd7e&chksm=fb419f3fcc3616298fafdee1da0baca258be010d2f9827a3afa7ca51a1a0535006bfd89917fb&scene=21#wechat_redirect)
[《385，位1的个数系列（二）》](http://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487255&idx=1&sn=10edf37fac36a3abff99b8106d3df24f&chksm=fb419c37cc36152153d4f6422a7fab17d2a669784fb762473b1316225b05d8b388ada5c6e3c9&scene=21#wechat_redirect)
[《402，位1的个数系列（三）》](http://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487573&idx=1&sn=a4bb8d5fd9159f49065ab2a4e73adf35&chksm=fb418375cc360a6378139c3e2eb3db57483de790824ebdabd91a49737cc5ec275dff835dfb68&scene=21#wechat_redirect)


**注意：**
```
1431655765的二进制是：01010101 01010101 01010101 01010101 
858993459 的二进制是：00110011 00110011 00110011 00110011 
252645135 的二进制是：00001111 00001111 00001111 00001111 
'\uff00'  的二进制是：00000000 00000000 11111111 00000000 
```

来看下代码

```java
    public static int reverseBits(int var0) {
        var0 = (var0 & 1431655765) << 1 | var0 >>> 1 & 1431655765;
        var0 = (var0 & 858993459) << 2 | var0 >>> 2 & 858993459;
        var0 = (var0 & 252645135) << 4 | var0 >>> 4 & 252645135;
        var0 = var0 << 24 | (var0 & '\uff00') << 8 | var0 >>> 8 & '\uff00' | var0 >>> 24;
        return var0;
    }
```

来看一下运行结果

![image.png](https://pic.leetcode-cn.com/1616210033-Gavgof-image.png)




<br>

我把部分算法题整理成了PDF文档，截止目前总共有**900多页**，大家可以下载阅读
**链接**：https://pan.baidu.com/s/1hjwK0ZeRxYGB8lIkbKuQgQ 
**提取码**：6666 

#### 如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解