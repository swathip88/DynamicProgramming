class ContinuousSubarraySum {
    //https://leetcode.com/problems/continuous-subarray-sum/
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int currSum = 0;
        hashmap.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            
            if(hashmap.containsKey(currSum % k)) {
                if(i - hashmap.get(currSum % k) >= 2) return true;
            }
            else hashmap.put(currSum % k, i);
        }
        
        return false;
    }
}
