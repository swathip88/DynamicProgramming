class MinimumPathSum {
    //https://leetcode.com/problems/minimum-path-sum/submissions/
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        
        dp[0][0] = grid[0][0];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                
                if(i==0){
                    if(j>0){
                        dp[i][j] = dp[i][j-1] + grid[i][j];    
                    }
                }
                else if(j==0){
                    if(i>0){
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);    
                }
                
            }
        }
        return dp[rows-1][cols-1];
    }
}
