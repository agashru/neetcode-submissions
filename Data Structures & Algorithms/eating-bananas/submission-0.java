class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 1;
        for(int p : piles){
            max = Math.max(max, p);
        }

        int l = min;
        int r = max;

        while(l < r){
            int m = l + (r-l) / 2;

            if(canEat(piles, m , h)){
                r = m;
            } else{
                 l = m + 1;
            }
        }
        return l;
    }

    public boolean canEat(int[] piles, int mid, int h){
        int sum = 0;

        for(int p : piles){
            sum +=  p / mid;

            if(p % mid != 0){
                sum ++;
            }
        }
        return sum <= h;
    }
}
