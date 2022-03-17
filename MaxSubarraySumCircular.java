class MaxSubarraySumCircular {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/submissions/
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0] ;
        int maxSum = nums[0];
        int min = nums[0];
        int minSum = nums[0];
        int total = nums[0];
        
        for(int i = 1;i<nums.length;i++){
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            max = Math.max(maxSum, max);
            minSum = Math.min(minSum + nums[i], nums[i]);
            min= Math.min(min, minSum);
            total += nums[i];
        }
        
        if(max<0) return max;
        
        return Math.max(max, total-min);
    }
}
