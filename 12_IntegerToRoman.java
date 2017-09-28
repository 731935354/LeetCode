class Solution {
    public static String intToRoman(int num) {
        TreeMap<Integer, String> intToReverseRoman = new TreeMap<>();
        intToReverseRoman = initMap(intToReverseRoman);
        int remainer = num; // 记录总体剩余部分
        int digit = 0; // 记录某一位的数字
        int base = 1; // 基数，digit * base 为某一位置的数字代表的实际值
        String roman = "";
        while(remainer != 0) {
            digit = remainer % 10;
            remainer = remainer / 10;
            if(digit != 0)
                roman += reverse(intToReverseRoman.get(digit * base));
            base *= 10;
        }
        return reverse(roman);
    }

    // 字符串翻转
    public static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    // 用TreeMap竟然超时了，所以暴力HashMap
    public static TreeMap<Integer, String> initMap(TreeMap<Integer, String> intToReverseRoman) {
        intToReverseRoman.put(1, "I");
        intToReverseRoman.put(2, "II");
        intToReverseRoman.put(3, "III");
        intToReverseRoman.put(4, "IV");
        intToReverseRoman.put(5, "V");
        intToReverseRoman.put(6, "VI");
        intToReverseRoman.put(7, "VII");
        intToReverseRoman.put(8, "VIII");
        intToReverseRoman.put(9, "IX");
        intToReverseRoman.put(10, "X");
        intToReverseRoman.put(20, "XX");
        intToReverseRoman.put(30, "XXX");
        intToReverseRoman.put(40, "XL");
        intToReverseRoman.put(50, "L");
        intToReverseRoman.put(60, "LX");
        intToReverseRoman.put(70, "LXX");
        intToReverseRoman.put(80, "LXXX");
        intToReverseRoman.put(90, "XC");
        intToReverseRoman.put(100, "C");
        intToReverseRoman.put(200, "CC");
        intToReverseRoman.put(300, "CCC");
        intToReverseRoman.put(400, "CD");
        intToReverseRoman.put(500, "D");
        intToReverseRoman.put(600, "DC");
        intToReverseRoman.put(700, "DCC");
        intToReverseRoman.put(800, "DCCC");
        intToReverseRoman.put(900, "CM");
        intToReverseRoman.put(1000, "M");
        intToReverseRoman.put(2000, "MM");
        intToReverseRoman.put(3000, "MMM");
        return intToReverseRoman;
    }
}
