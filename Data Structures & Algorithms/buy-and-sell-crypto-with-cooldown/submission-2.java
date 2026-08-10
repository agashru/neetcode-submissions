class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i = 1 ; i < prices.length ; i++){
            int nbsp = obsp;
            int nssp = ossp;
            int ncsp = ocsp;

            if(ocsp - prices[i] > obsp){
                nbsp = ocsp - prices[i];
            }

            if(obsp + prices[i] > ossp){
                nssp = obsp + prices[i];
            }

            if(ossp > ocsp){
                ncsp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        return ossp;
    }
}
