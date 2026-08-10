class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1){
            return n;
        }

        int a = 1;
        int b = 2;
        int c = 3;
        for(int i = 2; i <= n ; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
