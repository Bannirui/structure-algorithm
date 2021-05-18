### 解题思路
![截屏2021-03-21 下午5.27.46.png](https://pic.leetcode-cn.com/1616318906-Ezkzft-%E6%88%AA%E5%B1%8F2021-03-21%20%E4%B8%8B%E5%8D%885.27.46.png)

## **[计算机原码](https://baike.baidu.com/item/%E5%8E%9F%E7%A0%81/1097586?fr=aladdin)**
原码(true form)是一种计算机中对数字的二进制定点表示方法。原码表示法在数值前面增加了一位符号位（即最高位为符号位）：正数该位为0，负数该位为1（0有两种表示：+0和-0），其余位表示数值的大小。
我们用8位二进制表示一个数
`+11的原码为00001011，-11的原码就是10001011`
## **[计算机补码](https://baike.baidu.com/item/%E8%A1%A5%E7%A0%81/6854613?fr=aladdin)**
**1、对于正数**
**正整数的补码是其二进制表示，与原码相同**。
例：+9的补码是00001001。（备注：这个+9的补码是用8位2进制来表示的，补码表示方式很多，还有16位二进制补码表示形式，以及32位二进制补码表示形式，64位进制补码表示形式等。每一种补码表示形式都只能表示有限的数字。）
**2、对于负数**
**求负整数的补码，将其原码除符号位外的所有位取反（0变1，1变0，符号位为1不变）后加1。**
同一个数字在不同的补码表示形式中是不同的。比如-15的补码，在8位二进制中是11110001，然而在16位二进制补码表示中，就是1111111111110001。以下都使用8位2进制来表示。
例：求-5的补码。
```
-5对应带符号位负数5（10000101）→除符号位外所有位取反（11111010）→加00000001(11111011)
所以-5的补码是11111011。
```
```
0的补码
数0的补码表示是唯一的。
[+0]补=[+0]反=[+0]原=00000000
[ -0]补=11111111+1=00000000
```



### 常规版本代码

```python3
class Solution:
    def toHex(self, num: int) -> str:
        #对于大于等于0的转换
        if num >= 0:
            #二进制格式
            bin_format = list(bin(num)[2:])
            lenth = len(bin_format)
            k_4 = lenth // 4
            zero_num = 0
            if lenth % 4 != 0:
                k_4 = lenth // 4 + 1
                zero_num = 4 - lenth % 4
            zero_num_ll_format = ['0'] * zero_num + bin_format
            #处理4位的二进制转化为16进制
            def pending_num(nums):
                s = "0123456789abcdef"
                num = 0
                for i in range(len(nums)):
                    num += int(nums[3 - i]) * (2 ** i) 
                return s[num]
            i = 0
            #结果列表
            result = []
            #循环k_4次
            while i < k_4:
                child_ll = zero_num_ll_format[i * 4 : (i + 1) * 4]
                i += 1
                result.append(pending_num(child_ll))
            return ''.join(result)
        else:
            #负数取反得正
            n_copy = abs(num)
            #二进制格式
            bin_format = list(bin(n_copy)[2:])
            #32位前面补0个数后的格式
            zero_num_ll_format = ['0'] * (32 - len(bin_format)) + bin_format
            #按位取反
            for i in range(len(zero_num_ll_format)):
                if zero_num_ll_format[i] == '0':
                    zero_num_ll_format[i] = '1'
                else:
                    zero_num_ll_format[i] = '0'
            #取反后的格式要+1得到负数补码
            #索引倒序，从后往前， b是进位,初始化为1
            index, b = 31, 1
            while b == 1 and index >= 0:
                #余数
                num = (b + int(zero_num_ll_format[index])) % 2
                #进位
                b = (b + int(zero_num_ll_format[index])) // 2
                if num:
                    zero_num_ll_format[index] = '1'
                else:
                    zero_num_ll_format[index] = '0'
                #索引减1
                index -= 1
            #处理4位的二进制转化为16进制
            def pending_num(nums):
                s = "0123456789abcdef"
                num = 0
                for i in range(len(nums)):
                    num += int(nums[3 - i]) * (2 ** i) 
                return s[num]
            i = 0
            #结果列表
            result = []
            #32位机器的16进制表示一共有8位，循环8次
            while i < 8:
                child_ll = zero_num_ll_format[i * 4 : (i + 1) * 4]
                i += 1
                result.append(pending_num(child_ll))
            return ''.join(result)
                
```
### 简洁版本代码(位操作)

```python3

class Solution:
    def toHex(self, num: int) -> str:
        #如果是0直接返回"0"
        if num == 0:
            return "0"
        #十六进制字符串
        s = "0123456789abcdef"
        result = []
        #因为是32位机器，所以是8个F
        num = num & 0xFFFFFFFF
        while num > 0:
            #从右至左，每4个bit位进行与操作，得到该十六进制的字符表示
            result.append(s[num & 0XF])
            #每次右移4位
            num = num >> 4
        #结果取反序返回
        return "".join(result[::-1])