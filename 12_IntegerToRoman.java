class Solution {
    // 我自己写的版本，leetcode上某大神的版本往下翻。
    public static String intToRoman(int num) {
        HashMap<Integer, String> intToReverseRoman = new HashMap<>();
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
    public static HashMap<Integer, String> initMap(HashMap<Integer, String> intToReverseRoman) {
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
    // 大神版本
    public static String intToRoman(int num) {
        String[] romanPieces= {"","I","II","III","IV","V","VI","VII","VIII","IX", // 个位的map
                                "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC", // 十位的map
                                "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM", // 百位的map
                                "","M","MM","MMM","MMMM"};                         // 千位的map
        return romanPieces[num/1000+30] + // 千位 
               romanPieces[(num/100)%10+20] + // 百位
               romanPieces[(num/10)%10+10] + // 十位
               romanPieces[num%10]; // 个位
    }
    // 另一位大神的版本
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }
}
