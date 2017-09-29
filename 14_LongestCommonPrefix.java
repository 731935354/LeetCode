class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int numOfStrs = strs.length;
        if(numOfStrs == 1) return strs[0];
        int minLen = strs[0].length();
        int end = 0;
        char base;
        // 找到最短字符串的长度
        for(int i = 0; i < numOfStrs; i++)
            if(strs[i].length() < minLen)
                minLen = strs[i].length();
        if(minLen < 1) return "";
        // 逐个对比
        for(; end < minLen; end++) {
            base = strs[0].charAt(end);
            for(int j = 0; j < numOfStrs; j++)
                if(strs[j].charAt(end) != base)
                    return strs[j].substring(0, end);
        }
        return strs[0].substring(0, end);    
    }
}
