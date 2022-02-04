class HouseRobberyI {
    //https://leetcode.com/problems/house-robber/submissions/
    public int rob(int[] nums) {
        int max = 0;
        int length = nums.length;
        if(length ==0 ){
            return 0;
        }else if(length ==1){
            return nums[0];
        }
        else if(length ==2){
            return Integer.max(nums[0], nums[1]);
        }
        
        int[] ans = new int[length];
        ans[0] = nums[0];
        if(nums[0] > nums[1]){
            ans[1] = nums[0];
        }else{
            ans[1] = nums[1];
        }
        
        for(int i=2;i<length;i++){
            ans[i] = Integer.max(ans[i-1], ans[i-2] + nums[i]);
        }
        
        return ans[length-1];
    }
}
