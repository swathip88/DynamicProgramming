class MaximumSubArraySum {
    //https://leetcode.com/problems/maximum-subarray/submissions/
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int max = nums[0];
        int cur = 0;
        for(int i=0;i<length;i++){
            if(cur < 0){
                cur = 0;
            }
            cur = cur + nums[i];
            int temp = max;
            max = Integer.max(max, cur);
        }
        
        return max;
    }
}
