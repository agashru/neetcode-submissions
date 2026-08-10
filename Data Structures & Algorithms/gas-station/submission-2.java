class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int earning = 0;
        int spent = 0;

        for(int i = 0; i < n ; i++){
            earning += gas[i];
            spent += cost[i];
        }

        if(spent > earning){
            return -1;
        }

        int sp = 0;
        int total = 0;
        for(int i = 0; i < n ; i++){
            total +=  gas[i] - cost[i];

            if(total < 0){
                sp = i + 1;
                total = 0;
            }
        }
        return sp;
    }
}
