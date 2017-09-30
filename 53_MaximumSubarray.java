class Solution {
    // 遍历计算，O(n^2)
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for(int i = 0; i < len; i++) {
            int tmp = 0;
            for(int j = i; j < len; j++) {
                tmp += nums[j];
                if(tmp > max) max = tmp;
            }
        }
        return max;
    }
}
