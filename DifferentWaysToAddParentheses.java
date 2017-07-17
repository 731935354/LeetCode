/**
 * Created by rongxin.zhu on 2017/7/17.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 思路：
 * 1.将表达式按运算符号切分成两部分（记录运算符）
 * 2.将两部分的所有结果组合运算（例：第一部分结果[1,2,3]，第二部分结果[4,5,6]，运算符为"*"，组合运算最终结果为[4,5,6,8,10,12,12,15,18])
 * 对于任意一部分，如果仅包含数字，则只可能有一种结果，为数字本身
 * 如果包含运算符，则返回步骤1和2，得出该部分的结果集合
 */

public class DifferentWaysToAddParentheses {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> reList = new ArrayList<>();
        // 如果input为空，则返回空的集合
        if(input.equals(""))
            return reList;
        // 如果input不包含运算符，则返回仅有一个元素的List
        if(!containOperator(input)) {
            reList.add(Integer.valueOf(input));
            return reList;
        }
        // 如果input包含运算符
        Map<Integer, String> opIndexMap = new HashMap<>();
        // 记录运算符及位置
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*')
                opIndexMap.put(i, String.valueOf(input.charAt(i)));
        }
        // 以运算符切分表达式
        Iterator iter = opIndexMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer opIndex =(Integer) entry.getKey();
            String operator =(String) entry.getValue();
            System.out.println(opIndex + "->" + operator);
            String left = input.substring(0, opIndex);
            String right = input.substring(opIndex + 1, input.length());
            System.out.println(left + "||" + right);
            reList.addAll(Compute(diffWaysToCompute(left), diffWaysToCompute(right), operator));
        }
        return reList;
    }

    public static List<Integer> Compute(List<Integer> left, List<Integer> right, String operator) {
        List<Integer> reList = new ArrayList<>();
        if(operator.equals("+")) {
            for(Integer num1: left)
                for(Integer num2: right)
                    reList.add(num1 + num2);
        }
        if(operator.equals("-")) {
            for(Integer num1: left)
                for(Integer num2: right)
                    reList.add(num1 - num2);
        }
        if(operator.equals("*")) {
            for(Integer num1: left)
                for(Integer num2: right)
                    reList.add(num1 * num2);
        }
        return reList;
    }


    public static boolean containOperator(String input) {
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*')
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("5*8-3+4"));
//        System.out.println(Compute(new ArrayList<Integer>(Arrays.asList(2, 3, 4)),
//                new ArrayList<Integer>(Arrays.asList(7, 8, 9)), "*"));
//        System.out.println("01234567".substring(0, 2));
//        System.out.println("01234567".substring(2, 8));
//        System.out.println(containOperator("2-1-1"));
    }
}
