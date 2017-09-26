class Solution {
    public int romanToInt(String s) {
        int i = 0;
        int result = 0;
        char[] arr = s.toCharArray();
        int len = s.length();
        if(s.length() == 1)
            return getNum(arr, 0);
        while(i < len-1) {
            if(isNineOrFour(arr, i, i+1)) {
                result += getNineOrFour(arr, i, i+1);
                i++;
            } else 
                result += getNum(arr, i);
            i++;
        }
        if(i < len) 
            result += getNum(arr, i);
        return result;
    }
    
    public boolean isNineOrFour(char[] arr, int i, int j) {
        return ((arr[i] == 'I' && arr[j] == 'X')
                || (arr[i] == 'X' && arr[j] == 'C')
                || (arr[i] == 'C' && arr[j] == 'M')
                || (arr[i] == 'I' && arr[j] == 'V')
                || (arr[i] == 'X' && arr[j] == 'L')
                || (arr[i] == 'C' && arr[j] == 'D'));
    }
                
    public int getNineOrFour(char[] arr, int i, int j) {
        if(arr[i] == 'I' && arr[j] == 'X')
            return 9;
        else if(arr[i] == 'X' && arr[j] == 'C')
            return 90;
        else if(arr[i] == 'C' && arr[j] == 'M')
            return 900;
        else if(arr[i] == 'I' && arr[j] == 'V')
            return 4;
        else if(arr[i] == 'X' && arr[j] == 'L')
            return 40;
        else if(arr[i] == 'C' && arr[j] == 'D')
            return 400;
        return 0;
    }
    
    public int getNum(char[] arr, int i) {
        if(arr[i] == 'I')
            return 1;
        else if(arr[i] == 'V')
            return 5;
        else if(arr[i] == 'X')
            return 10;
        else if(arr[i] == 'L')
            return 50;
        else if(arr[i] == 'C')
            return 100;
        else if(arr[i] == 'D')
            return 500;
        else if(arr[i] == 'M')
            return 1000;
        return 0;
    }
}
