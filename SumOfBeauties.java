class SumOfBeauties {
    public int sumOfBeauties(int[] nums) {
        int sum = 0;
        int length = nums.length;
        if(length<=2){
            return sum;
        }
        
        int[] minRight = new int[length];
        minRight[length - 1] = nums[length-1];
        
        for(int i = length -2 ;i>=0;i--){
            minRight[i] = Math.min(minRight[i+1], nums[i]);
        }
        int maxLeft = nums[0];
        
        for(int i= 1;i<length -1 ;i++){
            if(nums[i] > maxLeft && nums[i]<minRight[i+1]){
                sum+=2;
            }else if(nums[i]> nums[i-1] && nums[i] < nums[i+1]){
                sum+=1;
            }else{
                sum+=0;
            }
            maxLeft = Math.max(maxLeft, nums[i]);
        }
        
        return sum;
    }
}
