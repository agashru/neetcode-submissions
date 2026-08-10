class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = (m*n) - 1;

        while(l <= r){
            int mid = l + (r - l) /2;

            int i = mid / n;
            int j = mid % n;

            if(matrix[i][j] < target){
                l = mid + 1;
            } else if(matrix[i][j] > target){
                r = mid - 1;
            } else{
                return true;
            }
        }
        return false;
    }
}
