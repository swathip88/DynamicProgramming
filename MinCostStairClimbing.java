class MinCostStairClimbing {
    //https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
    public int minCostClimbingStairs(int[] cost) {
        int[] ans = new int[cost.length];
        if(cost.length == 0){
            return 0;
        }else if(cost.length == 1){
            return cost[0];
        }else if(cost.length == 2){
            return Math.min(cost[0], cost[1]);
        }
        ans[0] = cost[0];
        ans[1] = cost[1];
        
        for(int i=2;i<cost.length;i++){
            ans[i] = Math.min(ans[i-1] , ans[i-2]) + cost[i];
        }
        
        return Math.min(ans[ans.length -1], ans[ans.length -2]);
    }
}
