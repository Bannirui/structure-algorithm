package leetcode.editor.cn;

//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。
//
//
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0
//Unported (CC BY-SA 3.0) ）
//
// 例如，上面的二进制手表读取 “3:25”。
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
//
//
//
// 示例：
//
//
//输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"]
//
//
//
// 提示：
//
//
// 输出的顺序没有要求。
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
//
// Related Topics 位运算 回溯算法
// 👍 241 👎 0

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
        // solution.readBinaryWatch(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int HOUR = 12;
        private static final int MINUTE = 60;

        public List<String> readBinaryWatch(int turnedOn) {
            ArrayList<String> res = new ArrayList<>();
            for (int hour = 0; hour < HOUR; hour++) {
                for (int minute = 0; minute < MINUTE; minute++) {
                    if (bitsCount(hour) + bitsCount(minute) == turnedOn) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(hour).append(":");
                        if ((minute < 10)) {
                            sb.append("0");
                        }
                        sb.append(minute);
                        res.add(sb.toString());
                    }
                }
            }
            return res;
        }

        private int bitsCount(int num) {
            int count = 0;
            while (num > 0) {
                count++;
                num &= num - 1;
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
