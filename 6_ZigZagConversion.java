/**
 * Created by rongxin.zhu on 2017/7/6.
 */

/**
 *      a   e   i   m         a   e   i   m
 * 将   b d f h j l    转化为  b d f h j l     存入3个字符数组中
 *     c   g   k               c   g   k
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        int sLength = s.length();
        if(sLength <= 1 || numRows == 1 || sLength <= numRows)
            return s;
        // 所需列数
        int numCols = new Double(Math.ceil(sLength / (numRows - 1)) + 1).intValue();
        // 将字符序列按zigzag顺序填入数组
        char[][] zigzagMap = new char[numRows][numCols];
        int strIdx = 0;
        for(int i = 0; i < numCols; i++) {// 遍历列
            // 奇数列正向，空出最后一行
            if (i % 2 == 0) {
                for (int j = 0; j < numRows - 1; j++) {
                    if(strIdx >= s.length()) break;
                    zigzagMap[j][i] = s.charAt(strIdx);
//                    System.out.println(strIdx+"："+"(" + j + "," + i + "):" + s.charAt(strIdx));
                    strIdx++;
                }
            } else { // 偶数列反向，空出第一行
                for (int k = numRows - 1; k > 0; k--) {
                    if(strIdx >= s.length()) break;
                    zigzagMap[k][i] = s.charAt(strIdx);
//                    System.out.println(strIdx+"："+"(" + k + "," + i + "):" + s.charAt(strIdx));
                    strIdx++;
                }
            }
        }
        StringBuilder result = new StringBuilder("");
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(zigzagMap[i][j] != '\u0000') {
                    result.append(zigzagMap[i][j]);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("abcdefghijklm", 2));
    }
}
