/**
 * Created by rongxin.zhu on 2017/7/10.
 */

public class StringToInteger_atoi {

    public static int myAtoi(String str) {
        int idx = 0, result = 0, flag = 1;
        // 空串
        if(str.length() < 1) return 0;
        // 去掉开头空格
        while(str.charAt(idx) == ' ' && idx < str.length()) { idx++; }
        // 检测+号和-号
        if(str.charAt(idx) == '+' || str.charAt(idx) == '-') {
            flag = str.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }

        while(idx < str.length()) {
            // 获取当前位置数值
            int digit = str.charAt(idx) - '0';
            // 忽略尾部非数字部分
            if(digit < 0 || digit > 9) break;
            // 检测是否超过整数范围
            if(Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit)
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            idx++;
        }
        return flag * result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("123"));
    }
}
