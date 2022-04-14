//https://leetcode.com/problems/uncrossed-lines/submissions/

class MaxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[][] dp = new int[l1+1][l2+1];
        for (int i = l1-1; i>=0; i--)
            for(int j = l2-1; j>=0; j--)
                if (nums1[i] == nums2[j])
                    dp[i][j] = 1+ dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
        return dp[0][0];
    }

}
