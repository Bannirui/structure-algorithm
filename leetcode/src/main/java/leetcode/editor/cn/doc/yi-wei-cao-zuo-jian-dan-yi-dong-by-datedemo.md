### 解题思路
2进制转化16进制，也就是每4位合成一位。
于是，我们可以从低位存储到高位，每次移位操作4位，转化为对应字符，这里采用制表。
当num为0时，停止移位操作，于是高位0项被放弃。
最后只要把字符串反转即可。


这里我们用StringBuff，可以更加快速。因为String加操作会不停创建对象。
### 代码

```java
class Solution {
    public String toHex(int num) {

    // 优化前代码  依次移位操作
    //     StringBuffer buffer = new StringBuffer();
    //     char[] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    //     if(num==0) return "0";
    //    int res=0;
    //    boolean symbol=false;
    //    for(int i=1;i<33;i++){
    //          int tmp=0;
    //         if((num&0x80000000)==0x80000000) tmp=1;
    //         num=num<<1;
    //         res=res*2+tmp;
    //         if(res!=0) symbol=true;
    //        if((i%4)==0)
    //        {   
    //            if(symbol){
    //            buffer.append(arr[res]);
    //            res=0;
    //        }}
    //     }
    //    return buffer.toString();

// 优化后  每次移位4格
     StringBuffer buffer = new StringBuffer();
        char[] arr ="0123456789abcdef".toCharArray();
        if(num==0) return "0";
       while (num!=0){
           int tmp=num&15;
           buffer.append(arr[tmp]);
           num=num>>>4;
       }
       
       return buffer.reverse().toString();


    }
}
```