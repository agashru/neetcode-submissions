class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int first = 0;
        int second = 0;
        int third = 0;

        for(int[] t : triplets){
            if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]){
                first = Math.max(first, t[0]);
                second = Math.max(second, t[1]);
                third = Math.max(third, t[2]);
            }
        }

        return (first == target[0] && second == target[1] && third == target[2]);
    }
}
