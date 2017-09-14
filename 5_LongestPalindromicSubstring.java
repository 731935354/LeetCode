/**
 * Created by rongxin.zhu on 2017/6/30.
 */
public class LongestPalindromicSubstring {
    /**
     * * 中心扩展法
     */
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
    
    // 动态规划1
    public static String longestPalindromeDynamicProgramming_1(String s) {
        int len = s.length();
        int longestBegin = 0;
        int maxLen = 1;
        boolean[][] table = new boolean[1000][1000]; // 默认初始化所有元素为false

        for(int i = 0; i < len; i++) // 单个字符为回文串
            table[i][i] = true;

        for(int i = 0; i < len - 1; i++) { // 两个字符相同，为回文串
            if(s.charAt(i) == s.charAt(i+1)) {
                longestBegin = i;
                maxLen = 2;
                table[i][i+1] = true;
            }
        }

        // 3个以上字符的回文串
        for(int length = 3; length <= len; length++) {
            for(int i = 0; i < len - length + 1; i++) {
                int j = i + length - 1;
                if(s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) { // 如过第i个字母和第j个字母相同，且i与j中间为回文串，则i到j为回文串
                    table[i][j] = true;
                    maxLen = length;
                    longestBegin = i;
                }
            }
        }
        return s.substring(longestBegin, longestBegin + maxLen);
    }
    
    
    /**
     * 动态规划2
    */
    public static String longestPalindromeDynamicProgramming_2(String s) {
        int n=s.length();
        int longestBegin = 0;
        boolean[][] pal=new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen = 0;
        for (int i = 0; i < n; i++) {  // i作为终点
            int j = i;    //j作为起点
            while (j >= 0){
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    if(i - j + 1 > maxLen) {
                        longestBegin = j;
                        maxLen = i - j + 1;
                    }
                }
                j--;
            }
        }
        return s.substring(longestBegin, longestBegin + maxLen);
    }

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(longestPalindrome(str));
    }
}


