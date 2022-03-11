class LongestPalindromeSubstring {
    //https://leetcode.com/problems/longest-palindromic-substring/submissions/
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        
        if(s == null || s.length() <1) return "";
        
        for(int i=0;i<s.length();i++){
            int l1 = getPalindromeLength(s, i, i);
            int l2 = getPalindromeLength(s, i, i+1);
            int l = Math.max(l1, l2);
            if(l > end- start){
                start = i - (l-1)/2;
                end = i+ l/2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int getPalindromeLength(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        
        return right - left - 1;
    }
}
