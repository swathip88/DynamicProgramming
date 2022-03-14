class MaximumScoreFromMultiplications {
    //https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
  
    /*
      Figure out the state variables.In this case we have 3 states to maintain
      1) How many multiplications have happened. That we know easily from the prob stmt.
      2) How many elements from left of the array are chosen.
      3) How many elements from right of the array are chosen.
    */
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] ans = new int[multipliers.length+1][multipliers.length+1];
        
        for(int i=multipliers.length -1 ;i>=0;i--){
            for(int left= i ;left>=0;left--){
                int m = multipliers[i];
                int right = nums.length - 1 - (i- left);
                ans[i][left] = Math.max(m * nums[left] + ans[i+1][left+1], m * nums[right] + ans[i+1][left] );
            }
        }
        
        return ans[0][0];
    }
}
