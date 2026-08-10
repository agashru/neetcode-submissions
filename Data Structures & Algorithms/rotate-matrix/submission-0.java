class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;


        for(int i = 0; i < N ; i++){
            for(int j = i; j <N ; j++){
                swap(matrix, i, j , j , i);
            }
        }

        for(int i = 0; i < N; i++){
            reverse(matrix[i]);
        }
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2){
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private void reverse(int[] arr){
        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
