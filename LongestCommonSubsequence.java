class LongestCommonSubsequence {
    //https://leetcode.com/problems/longest-common-subsequence/submissions/
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] ans = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i=text1.length()-1;i>=0;i--){
            for(int j=text2.length()-1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    ans[i][j] = 1 + ans[i+1][j+1];    
                }
                else{
                    ans[i][j] = Math.max(ans[i][j+1], ans[i+1][j]);
                }
            }
        }
        
        return ans[0][0];
    }
}
