class MinDifficultySchedule {
    //https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/submissions/
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        // If we cannot schedule at least one job per day, 
        // it is impossible to create a schedule
        if (n < d) {
            return -1;
        }
        
        int dp[][] = new int[n][d + 1];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        //Fill in the base case. On the last day, last job has to be finished.
        dp[n-1][d] = jobDifficulty[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i][d] = Math.max(dp[i+1][d], jobDifficulty[i]);
        }
        
        
        for(int i=d-1;i>0;i--){
            for(int j=i-1;j<n-(d-i);j++){
                int hardest = 0;
                for(int k=j;k<n-(d-i);k++){
                    hardest = Math.max(hardest, jobDifficulty[k]);
                    dp[j][i] = Math.min(dp[j][i], hardest + dp[k+1][i+1]);
                }
            }
        }
        return dp[0][1];
    }
}
