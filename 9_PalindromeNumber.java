/**
 * Created by rongxin.zhu on 2017/8/31.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int left = 0, right = num.length() - 1;
        while(right > left) {
            if(num.charAt(left) != num.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}
