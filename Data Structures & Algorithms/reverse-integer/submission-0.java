class Solution {
    public int reverse(int x) {
        long ans = 0;
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x = -x;
        }

        while(x != 0){
            int rem = x % 10;
            ans = ans * 10 + rem;
            x = x/10;
        }

        if(isNegative){
            ans = -ans;
        }

        if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE){
            return 0;
        }
        return (int)ans;
    }
}
