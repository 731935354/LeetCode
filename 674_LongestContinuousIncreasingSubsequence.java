class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        int tmpLen = 1;
        int arrLen = nums.length;
        if(arrLen == 0) // 空数组
            return 0;
        for(int i = 1; i < arrLen; i++) { // 遍历
            if(nums[i] > nums[i-1])
                tmpLen++;
            else {
                if(tmpLen > maxLen)
                    maxLen = tmpLen;
                tmpLen = 1;
            }
        }
        if(tmpLen > maxLen)
            maxLen = tmpLen;
        return maxLen;
    }
}
