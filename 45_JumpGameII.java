// TLE
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] minStep = new int[len];
        minStep[0] = 0;
        for(int i = 1; i < len; i++)
            minStep[i] = -1;
        for(int i = 0; i < len-1; i++) {
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j < len) {
                    if(minStep[i+j] == -1) 
                        minStep[i+j] = minStep[i] + 1;
                    else if(minStep[i] + 1 < minStep[i + j])
                        minStep[i + j] = minStep[i] + 1;
                }
            }
        }
        return minStep[len - 1];
    }
}
