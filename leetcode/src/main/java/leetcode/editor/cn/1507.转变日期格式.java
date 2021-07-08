/*
 * @lc app=leetcode.cn id=1507 lang=java
 *
 * [1507] 转变日期格式
 */

// @lc code=start
class Solution {
    public String reformatDate(String date) {
        String[] dateArr = date.split("\\s+");
        String dayStr = dateArr[0];
        String monthStr = dateArr[1];
        String yearStr = dateArr[2];
        StringBuilder sb = new StringBuilder();
        // year
        sb.append(yearStr);
        sb.append("-");
        // month
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
        sb.append(monthMap.get(monthStr));
        sb.append("-");
        // day
        if (dayStr.charAt(1) >= '0' && dayStr.charAt(1) <= '9') {
            sb.append(dayStr.charAt(0));
            sb.append(dayStr.charAt(1));
        } else {
            sb.append('0');
            sb.append(dayStr.charAt(0));
        }
        return sb.toString();
    }
}
// @lc code=end
