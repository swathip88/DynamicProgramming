class Tribonacci {
     //https://leetcode.com/problems/n-th-tribonacci-number/submissions/
     public int tribonacci(int n) {
        if (n < 3) return n == 0 ? 0 : 1;

        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
          tmp = x + y + z;
          x = y;
          y = z;
          z = tmp;
        }
        return z;
    }
    
    public int tribonacciRecursive(int n) {
        if(n == 0){
            return 0;
        }else if(n ==1 || n ==2){
            return 1;
        }else{
            return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        }
    }
}
