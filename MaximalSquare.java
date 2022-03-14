class MaximalSquare {
    ////https://leetcode.com/problems/maximal-square/solution/
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] ans = new int[rows + 1][cols + 1];
        int max = 0;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1] == '1'){
                    ans[i][j] = Math.min(Math.min(ans[i-1][j], ans[i][j-1]), ans[i-1][j-1]) + 1;
                    max = Math.max(max, ans[i][j]);
                }
            }
        }
        
        return max * max;
    }
}
