class NumRollsToTarget {
    //https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/submissions/
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[31][1001];
        for(int i=0;i<31;i++){
            for(int j=0;j<1001;j++){
                dp[i][j]=-1;
            }
        }
        return rec(n,k,target,dp);
    }
    static int rec(int n,int k,int target,int dp[][]){
        if(n==0&&target==0){
            return 1;
        }
        if(n<0||target<0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int res=0;
        for(int i=1;i<=k;i++){
            res+=rec(n-1,k,target-i,dp);
            res=res%1000000007;
        }
        dp[n][target]=res;
        return res;
    }
}
