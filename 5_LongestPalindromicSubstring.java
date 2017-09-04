/**
 * Created by rongxin.zhu on 2017/6/30.
 * 中心扩展法，竟然超时了。。。
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String result = "";
        if(s == null)
            return null;
        if(s.length() == 1)
            return s;

        for(int i = 0; i < s.length(); i++) {
            String temp = searchFromLeftAndRight(s, i, i);
            if (temp.length() > result.length())
                result = temp;
            temp = searchFromLeftAndRight(s, i, i + 1);
            if (temp.length() > result.length())
                result = temp;
        }
        return result;
    }

    public static String searchFromLeftAndRight(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(longestPalindrome(str));
    }
}
