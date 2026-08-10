class Solution {
    public int maxProfit(int[] prices) {
        int lsp = Integer.MAX_VALUE;
        int op = 0;
        //int pist = 0;

        for(int p : prices){
            if(p < lsp){
                lsp = p;
            }
            int pist = p - lsp;
            op = Math.max(pist, op);
        }
        return op;
    }
}
