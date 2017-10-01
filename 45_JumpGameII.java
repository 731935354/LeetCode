class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int curBegin = 0, curEnd = 0, curMax = 0, step = 0;
        for(int i = 0; i < nums.length-1; i++) {
            curMax = Math.max(nums[i]+i, curMax);
            if(i == curEnd) {
                step++;
                curEnd = curMax;
            }
        }
        return step;
    }
}
