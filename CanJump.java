class CanJump {
    //https://leetcode.com/problems/jump-game/submissions/
    public boolean canJump(int[] nums) {
        int nearestTrue = nums.length - 1;
        
        for(int i=nums.length-2;i>=0; i--){
            int diff = nearestTrue - i;
            if(nums[i] >= diff){
                nearestTrue = i;
            }
        }
        
        return nearestTrue == 0;
    }
}
