class MaxProductSubArray {
    //https://leetcode.com/problems/maximum-product-subarray/submissions/
    public int maxProduct(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int temp = max;
            max = Integer.max(nums[i], Integer.max((max*nums[i]), (min*nums[i])));
            min = Integer.min(nums[i], Integer.min((nums[i]*temp), (nums[i]*min)));
            ans = Integer.max(ans, max);
        }
        
        return ans;
        
    }
}
